package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class TestEndpoint {

    @PostConstruct
    public void init() {
        System.out.println("salut ça va ?");
    }

    @RequestMapping("/salut")
    public String salut() {
        return "ça va ?";
    }

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public ResponseEntity<Response> push(@RequestBody Item item) {
        return ResponseEntity.ok(new Response("Handled : " + item.input));
    }

}
