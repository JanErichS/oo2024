package ee.tlu.kodutoo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StoreController {
    @Autowired
    StoreRepository storeRepo;

    @GetMapping("carstore")
    public List<StoreEntity> getStore(){return storeRepo.findAll();}

    @PostMapping("carstore")
    public List<StoreEntity> addStore(@RequestBody StoreEntity store){
        storeRepo.save(store);
        return getStore();
    }

    @DeleteMapping("carstore/{id}")
    public List<StoreEntity> deleteStore(@PathVariable Long id){
        storeRepo.deleteById(id);
        return storeRepo.findAll();
    }
}
