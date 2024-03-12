package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredientEntityController {
    List<IngredientEntity> ingredients = new ArrayList<>(); // IRL DB

    @GetMapping("toiduained")
    public List<IngredientEntity> getIngredients(){
        return ingredients;
    }

    // Postmapping pole browseri omadus
    @PostMapping("toiduained/{name}/{protein}/{fat}/{carbs}")
    public List<IngredientEntity> addIngredients(
            @PathVariable String name,
            @PathVariable int protein,
            @PathVariable int fat,
            @PathVariable int carbs
    ){
        if (protein + fat + carbs > 100){
            return ingredients;
        }
        IngredientEntity ingredient = new IngredientEntity(name, protein, fat, carbs);
        ingredients.add(ingredient);
        return ingredients;
    }

    @DeleteMapping("toiduained/{index}")
    public IngredientEntity deleteIngredient(@PathVariable int index){
        return ingredients.remove(index);
    }

    // IRL primary key järgi, prglt järjekorranum järgi
    @PutMapping("toiduained")
    public List<IngredientEntity> changeIngredients(
            @RequestParam int index,
            @RequestParam String name,
            @RequestParam int protein,
            @RequestParam int fat,
            @RequestParam int carbs
    ){
        IngredientEntity ingredient = new IngredientEntity(name, protein, fat, carbs);
        ingredients.set(index, ingredient);
        return ingredients;
    }

    // CRUD -> Create, Read (Kõik ja üks kindel), Update, Delete


    @GetMapping("toiduained/{index}")
    public IngredientEntity getOneIngredient(@PathVariable int index){
        return ingredients.get(index);
    }

    @GetMapping("toiduainete-koguarv")
    public int ingredientsTotal(){
        return ingredients.size();
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