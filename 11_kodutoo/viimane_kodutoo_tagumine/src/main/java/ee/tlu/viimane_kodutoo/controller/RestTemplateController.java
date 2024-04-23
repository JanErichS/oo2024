package ee.tlu.viimane_kodutoo.controller;

import ee.tlu.viimane_kodutoo.model.AllPaintings;
import ee.tlu.viimane_kodutoo.model.PaintingData;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;
import java.util.Random;

// https://metmuseum.github.io/#object API documentation.
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {
    // https://collectionapi.metmuseum.org/public/collection/v1/objects --> kõik objektid. 488048 tükki

    @GetMapping("paintings")
    public AllPaintings getAllPaintings() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://collectionapi.metmuseum.org/public/collection/v1/objects";
        ResponseEntity<AllPaintings> response = restTemplate.exchange(url, HttpMethod.GET, null, AllPaintings.class);
        return Objects.requireNonNull(response.getBody());
    }

    @GetMapping("paintings/{id}")
    public List<PaintingData> getCertainPainting(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://collectionapi.metmuseum.org/public/collection/v1/objects/" + id;

        ResponseEntity<PaintingData> response = restTemplate.exchange(url, HttpMethod.GET, null, PaintingData.class);

        return List.of(Objects.requireNonNull(response.getBody()));
    }

    @GetMapping("paintings/random")
    public ResponseEntity<?> getRandomPainting() {
        RestTemplate restTemplate = new RestTemplate();

        // Leian kõik id'd
        String url = "https://collectionapi.metmuseum.org/public/collection/v1/objects";
        ResponseEntity<AllPaintings> randomNum = restTemplate.exchange(url, HttpMethod.GET, null, AllPaintings.class);
        int totalCount = Objects.requireNonNull(randomNum.getBody()).total;

        // Loon suvalise id
        Random random = new Random();
        long randomId = random.nextInt(totalCount) + 1;
        url = "https://collectionapi.metmuseum.org/public/collection/v1/objects/" + randomId;
        //ResponseEntity<PaintingData> response = restTemplate.exchange(url, HttpMethod.GET, null, PaintingData.class);

        // Senjoor robotniku kood.
        // Kui andmestikus ei leidu sellist pilti, siis viskab, et pilti pole.
        try {
            ResponseEntity<PaintingData> response = restTemplate.exchange(url, HttpMethod.GET, null, PaintingData.class);
            return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Painting not available, please try again!");
        }
    }
}