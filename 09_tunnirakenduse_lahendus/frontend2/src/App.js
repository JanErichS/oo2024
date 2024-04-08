//import logo from './logo.svg';
import { useEffect, useRef, useState } from "react";
import "./App.css";

function App() {
  const [amount, setAmount] = useState(0);
  const [cars, setCar] = useState([]);
  const brandRef = useRef();
  const modelRef = useRef();
  const yearRef = useRef();
  const msrpRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/cars")
      .then((response) => response.json())
      .then((json) => {
        console.log(json.length);
        setAmount(json.length);
        setCar(json);
      });
  }, []);

  function deleteCar(carID) {
    fetch("http://localhost:8080/cars/" + carID, { method: "DELETE" })
      .then((response) => response.json())
      .then((json) => {
        setAmount(json.length);
        setCar(json);
      });
  }

  function addCar() {
    // Ei lase tühjasid kirjeid lisada.
    if (brandRef.current.value === "") {
      return;
    }
    const addedCar = {
      brand: brandRef.current.value,
      model: modelRef.current.value,
      year: yearRef.current.value,
      msrp: msrpRef.current.value,
    };
    fetch("http://localhost:8080/cars", {
      method: "POST",
      body: JSON.stringify(addedCar),
      headers: { "Content-Type": "application/json" },
    })
      .then((response) => response.json())
      .then((json) => {
        console.log(json);
        setAmount(json.length);
        setCar(json);
      });
  }

  return (
    <div className="App">
      Yello, siin on {amount} autut.
      <br />
      <br />
      <h2>Lisa uus auto</h2>
      <div className="addCar">
        <label>Auto bränd </label>
        <input ref={brandRef} type="text" />
        <br />
        <label>Auto mudel </label>
        <input ref={modelRef} type="text" />
        <br />
        <label>Auto valmistamisaasta </label>
        <input ref={yearRef} type="text" />
        <br />
        <label>Auto esialgne hind </label>
        <input ref={msrpRef} type="text" />
        <br />
        <button onClick={() => addCar()} id="addButton">Lisa</button>
      </div>
      <br />
      <br />
      {cars.map((t) => (
        <div>
          {t.brand + " " + t.model /* Esitan brandi ja mudeli */}
          <button onClick={() => deleteCar(t.id)} id="deleteButton">
            x
          </button>
        </div>
      ))}
    </div>
  );
}

export default App;
