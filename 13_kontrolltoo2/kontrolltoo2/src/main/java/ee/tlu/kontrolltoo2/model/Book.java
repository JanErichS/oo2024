package ee.tlu.kontrolltoo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book{
    public String title;
    public String subtitle;
    public String isbn13;
    public String price;
    public String image;
    public String url;
}
