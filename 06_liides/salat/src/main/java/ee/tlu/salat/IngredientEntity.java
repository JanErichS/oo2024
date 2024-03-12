package ee.tlu.salat;

import lombok.Getter;

@Getter
public class IngredientEntity {
    String name;
    int protein;
    int fat;
    int carbs;

    public IngredientEntity(String name, int protein, int fat, int carbs) {
        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }
}
