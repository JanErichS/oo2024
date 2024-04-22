package ee.tlu.salat.repository;


import ee.tlu.salat.entity.FoodComponent;
import org.springframework.data.jpa.repository.JpaRepository;

// public interface IngredientRepository extends JpaRepository<IngredientEntity, String>
public interface FoodComponentRepository extends JpaRepository<FoodComponent, Long> {
}
