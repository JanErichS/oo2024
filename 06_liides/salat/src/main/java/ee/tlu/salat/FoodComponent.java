package ee.tlu.salat;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Koosneb toiduaine + selle kogus
// Kartul + omadused ja kogus.
@Getter
@AllArgsConstructor // See nagu see pikk konstruktsioon.
public class FoodComponent {
    IngredientEntity ingredient;
    int amount;
}

