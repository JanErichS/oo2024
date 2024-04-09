package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Deprecated
@CrossOrigin(origins = "http://localhost:3000")
public class DEP_FoodComponentController {

    List<FoodComponent> foodComponents = new ArrayList<>();
    @PostMapping("toidukomponent")
    public List<FoodComponent> addFoodComponent(@RequestBody FoodComponent component){
        foodComponents.add(component);
        return foodComponents;
    }

    @PutMapping("toidukomponent/{index}")
    public List<FoodComponent> changeFoodComponent(@PathVariable int index, @RequestBody FoodComponent component){
        foodComponents.set(index, component);
        return foodComponents;
    }

}
