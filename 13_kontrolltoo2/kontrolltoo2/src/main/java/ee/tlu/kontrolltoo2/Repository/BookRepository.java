package ee.tlu.kontrolltoo2.Repository;

import ee.tlu.kontrolltoo2.Entity.BookStories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookStories, Long> {

    BookStories findFirstByOrderByPagesDesc();
}
