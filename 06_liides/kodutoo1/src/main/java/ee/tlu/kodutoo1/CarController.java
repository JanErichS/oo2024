package ee.tlu.kodutoo1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {
    List<CarEntity> cars = new ArrayList<>();

    @GetMapping("cars")
    public List<CarEntity> getCars(){
        return cars;
    }

    @PostMapping("cars/{name}/{model}/{year}/{msrp}")
    public List<CarEntity> addCars(
            @PathVariable String name,
            @PathVariable String model,
            @PathVariable int year,
            @PathVariable double msrp
            ) {
        CarEntity car = new CarEntity(name, model, year, msrp);
        cars.add(car);
        return cars;
    }

    @PutMapping("cars/{index}/{name}/{model}/{year}/{msrp}")
    public List<CarEntity> changeCars(
            @PathVariable int index,
            @PathVariable String name,
            @PathVariable String model,
            @PathVariable int year,
            @PathVariable double msrp
    ) {
        CarEntity car = new CarEntity(name, model, year, msrp);
        cars.set(index, car);
        return cars;
    }

    @DeleteMapping("cars/{index}")
    public CarEntity deleteCar(@PathVariable int index){
        return cars.remove(index);
    }

    @GetMapping("cars/totalCost")
    public double totalCarCost(){
        // Finds the total sum of all the cars (msrp).
        double totalPrice = 0;
        for (CarEntity car : cars) {
            totalPrice += car.msrp;
        }
        return totalPrice;
    }
}
