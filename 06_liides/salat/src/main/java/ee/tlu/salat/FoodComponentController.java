package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FoodComponentController {
    @Autowired
    FoodComponentRepository componentRepository;

    @GetMapping("toidukomponendid")
    public List<FoodComponent> getComponents(){return componentRepository.findAll();}


    @PostMapping("toidukomponendid")
    public List<FoodComponent> addFoodComponent(@RequestBody FoodComponent component){
        componentRepository.save(component);
        return componentRepository.findAll();
    }

    // 1 muutuja urlis path /4/, mitu requestparam ?id=4
    @DeleteMapping("toidukomponendid/{id}")
    public List<FoodComponent> deleteFoodComponent(@PathVariable Long id){
        componentRepository.deleteById(id);
        return componentRepository.findAll();
    }
}
