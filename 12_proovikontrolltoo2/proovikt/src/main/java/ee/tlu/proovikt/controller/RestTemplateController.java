package ee.tlu.proovikt.controller;

import ee.tlu.proovikt.model.Products;
import ee.tlu.proovikt.model.Rating;
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

// https://reqres.in/api/users
// https://fakestoreapi.com/products

// localhost:8080/
@RestController
public class RestTemplateController {
    // localhost:8080/hankija-tooted
    @GetMapping("hankija-tooted")
    public List<Products> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<Products[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Products[].class);

        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    @GetMapping("hankija-tooted/{rating}")
    public List<Products> getProductsByRating(@PathVariable Rating rating) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<Products[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Products[].class);

        ArrayList<Products> applicableProducts = new ArrayList<>();

        for (Products product : Objects.requireNonNull(response.getBody())) {
            if (product.rating.rate > rating.rate) {
                applicableProducts.add(product);
            }
        }

        return applicableProducts;
    }
}
