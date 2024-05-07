import "./App.css";
import { useEffect, useRef, useState } from "react";

function App() {
	const [amount, setAmount] = useState(0);
	const [shortStories, setShortStories] = useState([]);
	const [books, setBooks] = useState([]);
	const titleRef = useRef();
	const contentRef = useRef();
	const yearRef = useRef();
	//const bookIDRef = useRef();

	useEffect(() => {
		fetch("http://localhost:8080/novellid")
			.then((response) => response.json())
			.then((json) => {
				setShortStories(json);
			});
	}, []);

	// Fetch raamatutele
	useEffect(() => {
		fetch("http://localhost:8080/raamatud")
			.then((response) => response.json())
			.then((json) => {
				setBooks(json);
			});
	}, []);

	function addShortStories() {
		if (titleRef.current.value === "" || contentRef.current.value === "") {
			return;
		}
		const addedShortStory = {
			title: titleRef.current.value,
			content: contentRef.current.value,
			year: yearRef.current.value
			//book: { id: bookIDRef.current.value }
		};
		fetch("http://localhost:8080/novellid", {
			method: "POST",
			body: JSON.stringify(addedShortStory),
			headers: { "Content-Type": "application/json" }
		})
			.then((response) => response.json())
			.then((json) => {
				setAmount(json.length);
				setShortStories(json);
			});
	}

	function deleteShortStory(key) {
		fetch("http://localhost:8080/novellid/" + key, { method: "DELETE" })
			.then((response) => response.json())
			.then((json) => {
				setAmount(json.length);
				setShortStories(json);
			});
	}

	return (
		<div className="App">
			Olemas on {amount} novelli.
			<br />
			<br />
			<div className="addShortStory">
				<h2>Lisa novell</h2>
				<label>Pealkiri</label>
				<input ref={titleRef} type="text" />
				<br />
				<label>Aasta </label>
				<input ref={yearRef} type="number" />
				<br />
				<label>Sisu </label>
				<br />
				<textarea
					ref={contentRef}
					id="long-text"
					name="long-text"
					rows="4"
					cols="50"
				/>
				<br />

				<button onClick={() => addShortStories()} id="addButton">
					Sisesta
				</button>
			</div>
			{shortStories.map((t) => (
				<div>
					{t.title}{" "}
					<button onClick={() => deleteShortStory(t.id)} id="deleteButton">
						x
					</button>
				</div>
			))}
			<br />
			{books.map((t) => (
				<div>
					ID: {t.id} | {t.title}
					{/*<input type="radio" value={t.id} ref={bookIDRef}></input>*/}
				</div>
			))}
		</div>
	);
}

export default App;
