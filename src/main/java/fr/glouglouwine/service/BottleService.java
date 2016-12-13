package fr.glouglouwine.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BottleService {

    private static final Logger logger = LoggerFactory.getLogger(BottleService.class);

    static {
        logger.info("class loading");
    }

    public BottleService() {
        logger.info("instanciation");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("post construct");
    }

    public void hello() {
        logger.info("hello");
    }

}
