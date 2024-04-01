package ee.tlu.kodutoo1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "car")
@Entity
@NoArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Laseb andmebaasil luua A-I id
    private Long id;
    public String brand;
    public String model;
    public int year;
    public double msrp;

}
