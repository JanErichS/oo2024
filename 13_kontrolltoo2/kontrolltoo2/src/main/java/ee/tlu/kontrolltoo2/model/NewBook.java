package ee.tlu.kontrolltoo2.model;

import java.util.ArrayList;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewBook {
        public int id;
        public String title;
        public String author;
        public Object publication_year;
        public ArrayList<String> genre;
        public String description;
        public String cover_image;
}
