package ee.tlu.kodutoo1;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    CarRepository carRepository; // Võiks teha @Autowired-iga.

    public CarController(CarRepository carRepository){
        this.carRepository = carRepository;
    } // See sobib ka, vali ise.
    @GetMapping("cars")
    public List<CarEntity> getCars(){
        return carRepository.findAll();
    }

    @PostMapping("cars")
    public List<CarEntity> addCars(
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam int year,
            @RequestParam double msrp
            ) {
        CarEntity car = new CarEntity(null, brand, model, year, msrp);
        carRepository.save(car);
        return carRepository.findAll();
    }

    @PutMapping("cars/{id}/")
    public List<CarEntity> changeCars(
            @PathVariable Long id,
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam int year,
            @RequestParam double msrp
    ) {
        CarEntity car = new CarEntity(id, brand, model, year, msrp);
        carRepository.save(car);
        return carRepository.findAll();
    }

    @DeleteMapping("cars/{id}")
    public CarEntity deleteCar(@PathVariable Long id){
        // To show what was deleted, we have to get it first.
        Optional<CarEntity> deletedCarOptional = carRepository.findById(id);


        CarEntity deletedCar = deletedCarOptional.get();
        carRepository.deleteById(id);
        return deletedCar;
    }

    @GetMapping("cars/totalCost")
    public double totalCarCost(){
        // Finds the total sum of all the cars (msrp).
        List<CarEntity> cars = carRepository.findAll();
        double totalPrice = 0;
        for (CarEntity car : cars) {
            totalPrice += car.msrp;
        }
        return totalPrice;
    }
}
