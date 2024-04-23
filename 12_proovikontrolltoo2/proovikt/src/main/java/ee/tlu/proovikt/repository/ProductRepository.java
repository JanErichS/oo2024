package ee.tlu.proovikt.repository;

import ee.tlu.proovikt.model.DatabaseProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<DatabaseProducts, Long> {

    List<DatabaseProducts> findByPriceBetween(double priceStart, double priceEnd);
    DatabaseProducts findFirstByPriceNotNullOrderByPriceDesc();
    DatabaseProducts findFirstByPriceNotNullOrderByPriceAsc();

    /*
        //Lic katsetus
        List<Product> findByNameContains(String name);
        List<Product> findByNameStartsWith(String name); */
}
