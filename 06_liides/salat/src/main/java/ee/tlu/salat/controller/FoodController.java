package ee.tlu.salat.controller;

import ee.tlu.salat.entity.Food;
import ee.tlu.salat.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {
    @Autowired
    FoodRepository foodRepository;

    @GetMapping("toit")
    public List<Food> getFood(){
        return foodRepository.findAll();
    }

    @PostMapping("toit")
    public List<Food> addFood(@RequestBody Food food) {
        foodRepository.save(food);
        return foodRepository.findAll();
    }

    @DeleteMapping("toit/{id}")
    public List<Food> deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
        return foodRepository.findAll();
    }
}
