package ee.tlu.kontrolltoo2.Controller;

import ee.tlu.kontrolltoo2.model.Book;
import ee.tlu.kontrolltoo2.model.NewBook;
import ee.tlu.kontrolltoo2.model.Root;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class RestTemplateController {

    @GetMapping("books/all")
    public List<Book>  getAllBooks() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/mongodb";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);

        return Objects.requireNonNull(response.getBody()).getBooks();
    }

    @GetMapping("books/titles")
    public List<String> getAllTitles() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/mongodb";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);

        return Objects.requireNonNull(response.getBody())
                .getBooks()
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @GetMapping("books/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/mongodb";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, null, Root.class);


        for (Book book : Objects.requireNonNull(response.getBody()).getBooks()) {
            System.out.println("Book Title: " + book.getTitle());
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }



    //https://freetestapi.com/api/v1/books

    //Näita eraldi API otspunktides kõige vanemat raamatut,
    @GetMapping("books-oldest")
    public NewBook getOldestBook() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<NewBook[]> response = restTemplate.exchange(url, HttpMethod.GET, null, NewBook[].class);
        NewBook[] books = response.getBody();
        NewBook oldestBook = books[0];

        for (int i = 1; i < books.length; i++) {
            try {
                int currentYear = Integer.parseInt(books[i].getPublication_year().toString());
                int oldestYear = Integer.parseInt(oldestBook.getPublication_year().toString());

                if (currentYear < oldestYear) {
                    oldestBook = books[i];
                }
            } catch (NumberFormatException e) {
                continue;
            }

        }

        return oldestBook;
    }


    // kõik raamatud uuemad kui sisestatud aasta,
    @GetMapping("books-older-than/{year}")
    public List<NewBook> getBookOlderThan(@PathVariable int year) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<NewBook[]> response = restTemplate.exchange(url, HttpMethod.GET, null, NewBook[].class);

        NewBook[] books = response.getBody();
        List<NewBook> olderThan = new ArrayList<>();

        assert books != null;
        for (NewBook book : books) {
            try {
                if (Integer.parseInt(String.valueOf(book.publication_year)) > year) {
                    olderThan.add(book);
                }
            } catch (NumberFormatException e) {
                continue;
            }

        }

        return olderThan;
    }

    //kõik raamatud sisestatud aastate vahemikus (kokku 3tk).
    @GetMapping("books-between/{yearStart}/{yearEnd}")
    public List<NewBook> getBooksBetween(@PathVariable int yearStart, @PathVariable int yearEnd) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://freetestapi.com/api/v1/books";
        ResponseEntity<NewBook[]> response = restTemplate.exchange(url, HttpMethod.GET, null, NewBook[].class);


        List<NewBook> booksBetween = new ArrayList<>();

        for (NewBook book : response.getBody()) {
            try {
                if (Integer.parseInt(String.valueOf(book.publication_year)) > yearStart && yearEnd > Integer.parseInt(String.valueOf(book.publication_year))) {
                    booksBetween.add(book);
                }
            } catch (NumberFormatException e) {
                continue;
            }

        }

        return booksBetween;
    }
}
