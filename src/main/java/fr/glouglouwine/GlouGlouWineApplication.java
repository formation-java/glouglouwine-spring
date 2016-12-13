package fr.glouglouwine;

import fr.glouglouwine.service.BottleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GlouGlouWineApplication {

    private static final Logger logger = LoggerFactory.getLogger(GlouGlouWineApplication.class);

    static {
        logger.info("class loading");
    }

    @Autowired
    private BottleService bottleService;

    public static void main(String[] args) {
        logger.info("instanciation");
        SpringApplication.run(GlouGlouWineApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("post construct");
        bottleService.hello();
    }
}
