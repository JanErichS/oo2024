package ee.tlu.salat;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// public interface IngredientRepository extends JpaRepository<IngredientEntity, String>
public interface FoodComponentRepository extends JpaRepository<FoodComponent, Long> {
}
