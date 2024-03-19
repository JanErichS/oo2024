package ee.tlu.salat;

import org.springframework.data.jpa.repository.JpaRepository;

// Igale tabelile oma repo vaja luua.
public interface IngredientRepository extends JpaRepository<IngredientEntity, String> {
}
