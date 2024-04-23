import { useEffect, useRef, useState } from "react";
import "./App.css";

function App() {
	const [amount, setAmount] = useState(0);
	const [products, setProducts] = useState([]);
	const nameRef = useRef();
	const priceRef = useRef();
	const activeRef = useRef();

	useEffect(() => {
		fetch("http://localhost:8080/toode")
			.then((response) => response.json())
			.then((json) => {
				setProducts(json);
				setAmount(json.length);
			});
	}, []);

	function deleteProduct(key) {
		fetch("http://localhost:8080/toode/" + key, { method: "DELETE" })
			.then((response) => response.json())
			.then((json) => {
				setAmount(json.length);
				setProducts(json);
			});
	}

	function addProduct() {
		// To migate empty entries.
		if (nameRef.current.value.trim() === "") {
			return;
		}

		const productAdded = {
			name: nameRef.current.value,
			price: parseFloat(priceRef.current.value),
			active: Boolean(activeRef.current.checked)
		};
		console.log(productAdded);
		fetch("http://localhost:8080/toode", {
			method: "POST",
			body: JSON.stringify(productAdded),
			headers: { "Content-Type": "application/json" }
		})
			.then((response) => response.json())
			.then((json) => {
				setAmount(json.length);
				setProducts(json);
			});
	}

	return (
		<div className="App">
			Mul on {amount} Tootet
			<br />
			<br />
			<div className="addProduct">
				<h2>Lisa Toote</h2>
				<label>Toote nimetus </label>
				<input ref={nameRef} type="text" />
				<br />
				<label>Toote Hind </label>
				<input ref={priceRef} type="number" />
				<br />
				<label>Toote aktiivsus </label>
				<input ref={activeRef} type="checkbox" />
				<br />
				<button onClick={() => addProduct()} id="addButton">
					Sisesta
				</button>
			</div>
			<br />
			<br />
			{products.map((t) => (
				<div id="products">
					Nimetus: {t.name} | Hind: {t.price}
					<button onClick={() => deleteProduct(t.id)} id="deleteButton">
						x
					</button>
					<div
						style={{
							width: "20px",
							height: "20px",
							borderRadius: "50%",
							marginLeft: "10px"
						}}
						className={t.active ? "active" : "inactive"}></div>
				</div>
			))}
		</div>
	); // Return end
} // App end

export default App;
