package ee.tlu.proovikt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Loo uus rakendus veebipood, Tee talle mudel toode, repo, controller, millega, andmebaasi panna ja esita seda front endile.
// A-I id, nimetus, hind ja kas on aktiivne või mitte.
@Entity
@Getter
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private boolean active;

    // Lisab olemasolevasse tabelisse uue veeru.
    @ManyToOne
    private Category category;

    // loob uue tabeli.
    //@ManyToMany
    //List<Products> products;
}
