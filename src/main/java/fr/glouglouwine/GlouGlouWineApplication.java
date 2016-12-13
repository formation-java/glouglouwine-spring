package fr.glouglouwine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlouGlouWineApplication {

    private static final Logger logger = LoggerFactory.getLogger(GlouGlouWineApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GlouGlouWineApplication.class, args);
    }

}
