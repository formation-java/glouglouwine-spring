package fr.glouglouwine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlouglouApplication {

	private static final Logger logger = LoggerFactory.getLogger(GlouglouApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GlouglouApplication.class, args);
	}

}
