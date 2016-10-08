package com.example;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestEndpoint {

    @PostConstruct
    public void init() {
        System.out.println("salut ça va ?");
    }

}
