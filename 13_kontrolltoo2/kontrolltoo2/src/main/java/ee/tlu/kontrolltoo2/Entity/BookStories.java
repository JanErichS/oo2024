package ee.tlu.kontrolltoo2.Entity;


//Loo klass Raamat, millel on
// nimetus,
// maksumus,
// lehekülgede arv – primaarvõti lisa kas nimetus või automaatselt genereeritud ID.
// Lisa novelli tabelisse Ramaat, millega ta seotud on. Tee järgmised API otspunktid:

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class BookStories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public double price;
    public int pages;
}
