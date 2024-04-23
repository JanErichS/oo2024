package ee.tlu.proovikt.controller;

import ee.tlu.proovikt.model.DatabaseProducts;
import ee.tlu.proovikt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("toode")
    public List<DatabaseProducts> getProducts() { return productRepository.findAll(); }

    @PostMapping("toode")
    public List<DatabaseProducts> setProducts(@RequestBody DatabaseProducts productsToDatabase) {
        productRepository.save(productsToDatabase);
        return productRepository.findAll();
    }

    @DeleteMapping("toode/{id}")
    public List<DatabaseProducts> deleteProducts(@PathVariable long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @GetMapping("toode-vahel/{min}/{max}")
    public List<DatabaseProducts> getBetween(@PathVariable double min, @PathVariable double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    @GetMapping("toode-max")
    public DatabaseProducts getMaxPrice() {return productRepository.findFirstByPriceNotNullOrderByPriceDesc();}
    @GetMapping("toode-min")
    public DatabaseProducts getMinPrice() {return productRepository.findFirstByPriceNotNullOrderByPriceAsc();}

}
