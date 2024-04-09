package ee.tlu.salat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Comments
    // Koosneb toiduaine + selle kogus
    // Kartul + omadused ja kogus.
    // GenValue strategy'd.
    // Identity 1,2... |
    // Sequence valitud num + 1, eel + 1 ... |
    // UUID ülipikk ise gen.
    // @Table aint siis, kui tahad teha teise nimega tabeli.
    // DB kardinaalsused:
    // Kui klassid on seotud, tuleb lisada seos.
    // ManyToMany, kui list.
    // ManyToOne kui obj vmt.
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor // See nagu see pikk konstruktsioon.
public class FoodComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    IngredientEntity ingredient;
    int amount;
}

