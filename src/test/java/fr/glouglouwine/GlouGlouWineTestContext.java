package fr.glouglouwine;

import fr.glouglouwine.repository.BottleRepository;
import fr.glouglouwine.repository.TestBottleRepository;
import org.springframework.context.annotation.Bean;

public class GlouGlouWineTestContext extends GlouGlouWineApplication {

    @Bean
    public BottleRepository bottleRepository() {
        return new TestBottleRepository();
    }
}
