package ee.tlu.kodutoo1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarRequest {
    private String brand;
    private String model;
    private int year;
    private double msrp;
}
