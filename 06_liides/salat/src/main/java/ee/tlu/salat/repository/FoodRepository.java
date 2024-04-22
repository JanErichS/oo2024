package ee.tlu.salat.repository;

import ee.tlu.salat.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
