import { useEffect, useRef, useState } from "react";
import "./App.css";
// Muutujad on {}
// React -> Use
// Spring -> @ (annotation)
// const amount = 2; // Aint constid siin, variable ei saa.

function App() {
  // HTML muutujad peavad olema useState sees.
  const [amount, setAmount] = useState(0);
  const [ingredients, setIngredients] = useState([]);
  const nameRef = useRef();
  const proteinRef = useRef();
  const fatRef = useRef();
  const carbsRef = useRef();

  // TOIDUKOMPONENDID
  const [foodComponent, setFoodComponents] = useState([]);
  const ingredientNameRef = useRef();
  const ingredientAmountRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/toidukomponendid")
      .then((response) => response.json())
      .then((json) => {
        setFoodComponents(json);
      });
  }, []);

  function deleteComponent(id) {
    fetch("http://localhost:8080/toidukomponendid/" + id, { method: "DELETE" })
      .then((response) => response.json())
      .then((json) => {
        setFoodComponents(json);
      });
  }

  function addComponent() {
    const selectedIngredient = Array.from(
      document.getElementsByName("ingredient")
    ).find((input) => input.checked)?.value;
    
    // Kontroll, et vähemalt üks oleks olemas
    if (!selectedIngredient) {
      prompt("Toiduaine pole valitud.");
      return;
    }

    const addedComponent = {
      ingredient: { name: selectedIngredient },
      amount: ingredientAmountRef.current.value,
    };
    console.log(JSON.stringify(addedComponent));
    fetch("http://localhost:8080/toidukomponendid", {
      method: "POST",
      body: JSON.stringify(addedComponent),
      headers: { "Content-Type": "application/json" },
    })
      .then((response) => response.json())
      .then((json) => {
        setFoodComponents(json);
      });
  }

  // TOIDUAINED

  // Kui leht avatakse, tuleb mingi päring. uef
  useEffect(() => {
    fetch("http://localhost:8080/api/toiduained")
      .then((response) => response.json()) // Terve vaste (header, status jne)
      .then((json) => {
        console.log(json);
        setAmount(json.length);
        setIngredients(json);
      }); // Kere osa.
  }, []);

  // Primaarvõtme läbi kustutan.
  function deleteIngredient(key) {
    fetch("http://localhost:8080/api/toiduained/" + key, { method: "DELETE" })
      .then((response) => response.json())
      .then((json) => {
        setAmount(json.length);
        setIngredients(json);
      });
  }

  function addIngredient() {
    if (nameRef.current.value === "") {
      return;
    }
    const ingredientAdded = {
      name: nameRef.current.value,
      protein: proteinRef.current.value,
      fat: fatRef.current.value,
      carbs: carbsRef.current.value,
    };
    fetch("http://localhost:8080/api/toiduained", {
      method: "POST",
      body: JSON.stringify(ingredientAdded),
      headers: { "Content-Type": "application/json" },
    })
      .then((response) => response.json())
      .then((json) => {
        setAmount(json.length);
        setIngredients(json);
      });
  }

  // .map() -> Muudab kõiki
  return (
    <div className="App">
      Mul on {amount} toiduainet
      <br />
      <br />
      <div className="addIngredient">
        <h2>Lisa toiduaine</h2>
        <label>Toiduaine nimetus </label>
        <input ref={nameRef} type="text" />
        <br />
        <label>Toiduaine valk </label>
        <input ref={proteinRef} type="number" />
        <br />
        <label>Toiduaine rasv </label>
        <input ref={fatRef} type="number" />
        <br />
        <label>Toiduaine süsivesikud </label>
        <input ref={carbsRef} type="number" />
        <br />
        <button onClick={() => addIngredient()} id="addButton">
          Sisesta
        </button>
      </div>
      <br />
      <br />
      {ingredients.map((t) => (
        <div>
          {t.name}{" "}
          <button onClick={() => deleteIngredient(t.name)} id="deleteButton">
            x
          </button>
        </div>
      ))}
      <hr />
      <h2>Toidukomponent</h2>
      <h3>Lisa toidukomponent</h3>
      <br />
      Vali toiduaine
      <form>
        {ingredients.map((i) => (
          <div key={i.name}>
            <label>
              <input
                type="radio"
                name="ingredient"
                value={i.name}
                ref={ingredientNameRef}
              />
              {i.name}
            </label>
          </div>
        ))}
      </form>
      <br />
      <label>Toiduaine kogus</label> <br />
      <input type="number" ref={ingredientAmountRef} />
      <button onClick={() => addComponent()} id="addButton">
        Sisesta
      </button>
      <br />
      {foodComponent.map((f) => (
        <div>
          | {f.ingredient.name} | {f.amount} |{" "}
          <button onClick={() => deleteComponent(f.id)} id="deleteButton">
            x
          </button>
        </div>
      ))}
      <br />
    </div>
  );
}

export default App;
