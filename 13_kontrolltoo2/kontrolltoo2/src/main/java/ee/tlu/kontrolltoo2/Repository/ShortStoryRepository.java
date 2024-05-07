package ee.tlu.kontrolltoo2.Repository;

import ee.tlu.kontrolltoo2.Entity.ShortStory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShortStoryRepository extends JpaRepository<ShortStory, Long> {
    ShortStory findFirstByOrderByYearAsc();

    ShortStory findFirstByOrderByContentDesc();

    List<ShortStory> findByYearGreaterThan(int year);

    List<ShortStory> findByBookId(Long bookId);
}
