package ee.tlu.salat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Igale tabelile oma repo vaja luua.
public interface IngredientRepository extends JpaRepository<IngredientEntity, String> {
    // Siia saab lisada Custom repo käske, mis tagastavad entity või listi entititest.

    List<IngredientEntity> findAllByProteinGreaterThan(int protein);
    List<IngredientEntity> findAllByCarbsBetween(int min, int max);
}
