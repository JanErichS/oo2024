package ee.tlu.kodutoo1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumberController {
    List<Double> numbers = new ArrayList<>();

    @GetMapping("numbers")
    public List<Double> getNumbers(){
        return numbers;
    }

    @PostMapping("numbers/{newNum}")
    public List<Double> addNumbers(@PathVariable Double newNum){
        numbers.add(newNum);
        return numbers;
    }

    @DeleteMapping("numbers/{index}")
    public  List<Double> removeNumber(@PathVariable int index){
        numbers.remove(index);
        return numbers;
    }

    @GetMapping("numbers/count")
    public int countNumbers(){
        return numbers.size();
    }

    @GetMapping("numbers/sum")
    public Double sumOfNumbers(){
        double temp = 0;
        for (double num : numbers){
            temp += num;
        }
        return temp;
    }

    @GetMapping("numbers/average")
    public Double averageOfNumbers(){
        double temp = 0;
        for (double num : numbers){
            temp += num;
        }
        temp = temp / numbers.size();
        return temp;
    }
}
