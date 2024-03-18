package ee.tlu.kodutoo1;

import lombok.Getter;

@Getter
public class CarEntity {
    String name;
    String model;
    int year;
    double msrp;

    public CarEntity(String name, String model, int year, double msrp) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.msrp = msrp;
    }
}
