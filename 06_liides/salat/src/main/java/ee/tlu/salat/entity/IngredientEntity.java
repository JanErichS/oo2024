package ee.tlu.salat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Senjoor robotnik ei tea jakarta-t, vaid paneb javax.
@Getter // loob getMuutuja(){} funktsioonid --> muidu ei tööta.
@AllArgsConstructor
@Table(name = "ingredient")
@Entity
@NoArgsConstructor
public class IngredientEntity {
    @Id // Alati unikaalne; võtab nime id-ks.
    private String name;
    private int protein;
    private int fat;
    private int carbs;
}
