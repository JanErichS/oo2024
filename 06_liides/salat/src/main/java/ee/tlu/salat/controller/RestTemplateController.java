package ee.tlu.salat.controller;

import ee.tlu.salat.model.OmnivaPM;
import ee.tlu.salat.model.Post;
import ee.tlu.salat.model.nordpool.Nordpool;
import ee.tlu.salat.model.nordpool.TimestampPrice;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {

    @GetMapping("saa-postitus")
    public List<Post> getPost() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);
        return List.of(Objects.requireNonNull(response.getBody()));
    }

    @GetMapping("saa-postitus/{searchUID}")
    public List<Post> getSinglePost(@PathVariable int searchUID) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        // Siin muutub vaid url ning viimane vaste vorm.
        ResponseEntity<Post[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Post[].class);
        List<Post> userPosts = new ArrayList<>();

        // Response annab Array -> ei saa midagi teha pmst.
        for ( Post p : Objects.requireNonNull(response.getBody())) {
            if (p.getUserId() == searchUID) {
                userPosts.add(p);
            }
        }

        return userPosts;
    }

    @GetMapping("omniva")
    public List<OmnivaPM> getOmnivaPM() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";
        ResponseEntity<OmnivaPM[]> response = restTemplate.exchange(url, HttpMethod.GET, null, OmnivaPM[].class);
        return List.of(Objects.requireNonNull(response.getBody()));
    }

    // Filtreerimine, riigikooditi (String).
    @GetMapping("omniva/{countryCode}")
    public List<OmnivaPM> getOmnivaPMByCountry(@PathVariable String countryCode) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.omniva.ee/locations.json";

        ResponseEntity<OmnivaPM[]> response = restTemplate.exchange(url, HttpMethod.GET, null, OmnivaPM[].class);
        List<OmnivaPM> omnivaPMS = new ArrayList<>();

        for ( OmnivaPM o : Objects.requireNonNull(response.getBody())) {
            if (o.getA0_NAME().equals(countryCode)) {
                omnivaPMS.add(o);
            }
        }

        return omnivaPMS;
    }

    @GetMapping("saa-nordpool-hinnad")
    public Nordpool getNordpoolPrices() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dashboard.elering.ee/api/nps/price";
        ResponseEntity<Nordpool> response = restTemplate.exchange(url, HttpMethod.GET, null, Nordpool.class);
        return Objects.requireNonNull(response.getBody());
    }

    @GetMapping("saa-nordpool-hinnad/{countryCode}")
    public List<TimestampPrice> getNordpoolPricesByCountry(@PathVariable String countryCode) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dashboard.elering.ee/api/nps/price";

        ResponseEntity<Nordpool> response = restTemplate.exchange(url, HttpMethod.GET, null, Nordpool.class);

        // Pika else if-i asemel.
        return switch (countryCode) {
            case "ee" -> Objects.requireNonNull(response.getBody()).getData().getEe();
            case "lv" -> Objects.requireNonNull(response.getBody()).getData().getLv();
            case "lt" -> Objects.requireNonNull(response.getBody()).getData().getLt();
            case "fi" -> Objects.requireNonNull(response.getBody()).getData().getFi();
            //default -> nordpoolPrices;
            default -> throw new IllegalStateException("Unexpected value: " + countryCode);
        };
    }
}
