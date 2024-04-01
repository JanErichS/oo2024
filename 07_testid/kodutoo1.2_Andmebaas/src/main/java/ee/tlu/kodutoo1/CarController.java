package ee.tlu.kodutoo1;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    CarRepository carRepository;

    public CarController(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    @GetMapping("cars")
    public List<CarEntity> getCars(){
        return carRepository.findAll();
    }

    @PostMapping("cars/{name}/{model}/{year}/{msrp}")
    public List<CarEntity> addCars(
            @PathVariable String name,
            @PathVariable String model,
            @PathVariable int year,
            @PathVariable double msrp
            ) {
        CarEntity car = new CarEntity(null, name, model, year, msrp);
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
