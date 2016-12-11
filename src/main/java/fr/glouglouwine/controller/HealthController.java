package fr.glouglouwine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/")
    public String healthCheck() {
        return "hello you, I'm great !";
    }
}
