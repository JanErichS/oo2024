package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class IngredientController {
    List<String> ingredients = new ArrayList<>(); // IRL DB

    @GetMapping("toiduained")
    public List<String> getIngredients(){
        return ingredients;
    }

    // Postmapping pole browseri omadus
    @PostMapping("toiduained/{ingredient}")
    public List<String> addIngredients(@PathVariable String ingredient){
        ingredients.add(ingredient);
        return ingredients;
    }

    @DeleteMapping("toiduained/{index}")
    public String deleteIngredient(@PathVariable int index){
        return ingredients.remove(index);
    }

    // IRL primary key järgi, prglt järjekorranum järgi
    @PutMapping("toiduained/{index}/{newValue}")
    public List<String> removeIngredients(@PathVariable int index, @PathVariable String newValue){
        ingredients.set(index, newValue);
        return ingredients;
    }

    // CRUD -> Create, Read (Kõik ja üks kindel), Update, Delete


    @GetMapping("toiduained/{index}")
    public String getOneIngredient(@PathVariable int index){
        return ingredients.get(index);
    }
    @GetMapping("tere/{name}")
    public String hello(@PathVariable String name){
        return "Yello, " + name + "!";
    }
    @GetMapping("korruta/{num1}/{num2}")
    public int multiply(@PathVariable int num1, @PathVariable int num2){
        return num1 * num2;
    }
} // Class end

// 404 - URL ehk API otspunkt on vale; 4 alguses frontend viga
// 5 alguses - backend viga (serveri poolne)