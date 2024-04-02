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
      <h2>Lisa toiduaine</h2>
      <label>Toiduaine nimetus </label>
      <input ref={nameRef} type="text" />
      <br />
      <label>Toiduaine valk </label>
      <input ref={proteinRef} type="text" />
      <br />
      <label>Toiduaine rasv </label>
      <input ref={fatRef} type="text" />
      <br />
      <label>Toiduaine süsivesikud </label>
      <input ref={carbsRef} type="text" />
      <br />
      <button onClick={() => addIngredient()}>Sisesta</button>
      <br />
      <br />
      {ingredients.map((t) => (
        <div>
          {t.name} <button onClick={() => deleteIngredient(t.name)}>x</button>
        </div>
      ))}
    </div>
  );
}

export default App;
