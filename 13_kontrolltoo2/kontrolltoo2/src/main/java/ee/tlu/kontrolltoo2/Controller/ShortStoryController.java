package ee.tlu.kontrolltoo2.Controller;
import ee.tlu.kontrolltoo2.Entity.BookStories;
import ee.tlu.kontrolltoo2.Entity.ShortStory;
import ee.tlu.kontrolltoo2.Repository.BookRepository;
import ee.tlu.kontrolltoo2.Repository.ShortStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Võimalda novelle võtta andmebaasist, lisada andmebaasi kui ka kustutada andmebaasist.
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ShortStoryController {

    @Autowired
    ShortStoryRepository shortStoryRepository;

    @Autowired
    BookRepository bookRepository;


    //1) Näita kõiki raamatuid >_<
    @GetMapping("raamatud")
    public List<BookStories> getAllBooks() {
        return bookRepository.findAll();
    }

    //2) Näita kõiki novelle selles kindlas raamatus, mille API otspunkti andsid
    @GetMapping("raamatud/{id}")
    public List<ShortStory> getAllShortStoriesFromBooks(@PathVariable Long id) {
        return shortStoryRepository.findByBookId(id);
    }

    //3) Arvuta kokku API otspunktist kõikide raamatute kogumaksumus.
    @GetMapping("raamatud-maksumus")
    public double getBookPrices(){
        return bookRepository.findAll().stream().mapToDouble(BookStories::getPrice).sum();
    }

    //4) Näita API otspunktist kõikide raamatute kogumaksumust teises valuutas (sisesta API otspunkti kordaja, millega korrutad tagastatavat numbrit)
    @GetMapping("raamatud-maksumus/{exchangeRate}")
    public double getBookPricesDifferentCurrency(@PathVariable double exchangeRate){
        return bookRepository.findAll().stream()
                .mapToDouble(BookStories::getPrice)
                .sum() * exchangeRate;
    }

    //5) Võimalda API otspunktist võtta kõige suurema lehekülgede arvuga raamat.
    @GetMapping("raamatud-suurim")
    public BookStories getLargestBook() {
        return bookRepository.findFirstByOrderByPagesDesc();
    }

    //6) Selle raamatu kõikide novellide sisude tähemärgid kokkuliidetuna ja väljastatud ühe summana
    @GetMapping("raamatud-t2hem2rgid/{id}")
    public double getAllCharsSum(@PathVariable Long id) {
        return shortStoryRepository.findByBookId(id).stream().mapToInt(story -> story.getContent().length()).sum();
    }

    // Raamatu lisamine
    @PostMapping("raamatud")
    public List<BookStories> addBooks(@RequestBody BookStories book) {
        bookRepository.save(book);
        return bookRepository.findAll();
    }

    @GetMapping("novellid")
    public List<ShortStory> getAllShortStories() {
        return shortStoryRepository.findAll();
    }

    @PostMapping("novellid")
    public List<ShortStory> addShortStory(@RequestBody ShortStory shortStory){

        // Lisab vaid siis, kui sisu on suurem, kui 10 tähemärki.
        if (shortStory.content.length() >= 10) {
            shortStoryRepository.save(shortStory);
        }
        return shortStoryRepository.findAll();
    }

    @DeleteMapping("novellid/{id}")
    public List<ShortStory> deleteShortStory(@PathVariable Long id) {
        shortStoryRepository.deleteById(id);
        return shortStoryRepository.findAll();
    }


    @GetMapping("novellid-vanim")
    public ShortStory getOldestShortStory() {
        return shortStoryRepository.findFirstByOrderByYearAsc();
    }
    @GetMapping("novellid-lyhim")
    public ShortStory getShortestStory() {
        return shortStoryRepository.findFirstByOrderByContentDesc();
    }
    @GetMapping("novellid-uuem-kui/{year}")
    public List<ShortStory> getAllShortStoriesOlderThan(@PathVariable int year) {
        return shortStoryRepository.findByYearGreaterThan(year);
    }
}
