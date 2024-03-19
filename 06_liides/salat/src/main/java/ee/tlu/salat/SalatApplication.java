package ee.tlu.salat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalatApplication {
	// Kui üks "asi" on API lõpppunktis, siis @PathVariable, kui mitu siis @RequestBody.

	public static void main(String[] args) {
		SpringApplication.run(SalatApplication.class, args);
	}

}
