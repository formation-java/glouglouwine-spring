package fr.glouglouwine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HealthController {

    @RequestMapping("/test")
    public String healthCheck() {
        return "hello you, I'm great !";
    }
}
