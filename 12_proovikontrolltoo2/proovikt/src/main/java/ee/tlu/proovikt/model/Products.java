package ee.tlu.proovikt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    public Rating rating;
}
