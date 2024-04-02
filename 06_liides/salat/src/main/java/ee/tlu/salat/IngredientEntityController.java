package ee.tlu.salat;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class IngredientEntityController {

    // Esimene variant
    //    @Autowired
    //            IngredientRepository ingredientRepository;
    // Teine variant
    IngredientRepository ingredientRepository;
    public IngredientEntityController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    // List<IngredientEntity> ingredients = new ArrayList<>(); // IRL DB

    @GetMapping("toiduained")
    public List<IngredientEntity> getIngredients(){
        return ingredientRepository.findAll();
    }

    // Postmapping pole browseri omadus
    // Näide, pigem tee RequestParamiga.
    @PostMapping("toiduained/{name}/{protein}/{fat}/{carbs}/")
    public List<IngredientEntity> addIngredients(
            @PathVariable String name,
            @PathVariable int protein,
            @PathVariable int fat,
            @PathVariable int carbs
    ){
        if (protein + fat + carbs > 100){
            return ingredientRepository.findAll();
        }
        IngredientEntity ingredient = new IngredientEntity(name, protein, fat, carbs);
        ingredientRepository.save(ingredient);
        return ingredientRepository.findAll();
    }

    @PostMapping("toiduained")
    public List<IngredientEntity> addIngredientsAlso(@RequestBody IngredientEntity ingredientEntity){
        if (ingredientEntity.protein + ingredientEntity.fat + ingredientEntity.carbs > 100){
            return ingredientRepository.findAll();
        }

        ingredientRepository.save(ingredientEntity);
        return ingredientRepository.findAll();
    }

    @DeleteMapping("toiduained/{name}")
    public IngredientEntity deleteIngredient(@PathVariable String name){
        ingredientRepository.deleteById(name);
        return (IngredientEntity) ingredientRepository.findAll();
    }

    // IRL primary key järgi, prglt järjekorranum järgi
    @PutMapping("toiduained/muuda")
    public List<IngredientEntity> changeIngredients(
            @RequestParam String name,
            @RequestParam int protein,
            @RequestParam int fat,
            @RequestParam int carbs
    ){
        IngredientEntity ingredient = new IngredientEntity(name, protein, fat, carbs);
        ingredientRepository.save(ingredient);
        return ingredientRepository.findAll();
    }

    // CRUD -> Create, Read (Kõik ja üks kindel), Update, Delete


    @GetMapping("toiduained/{name}")
    public IngredientEntity getOneIngredient(@PathVariable String name){
        return ingredientRepository.findById(name).get();
    }

    @GetMapping("toiduained-koguarv")
    public long ingredientsTotal(){
        return ingredientRepository.findAll().size();
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