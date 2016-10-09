package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class TestEndpoint {

    @Autowired
    private TestService testService;
    @Autowired
    private MyGlobalState myGlobalState;
    @Autowired
    private MyRequestContext myRequestContext;

    @PostConstruct
    public void init() {
        System.out.println("salut ça va tak tak ?");
    }

    @RequestMapping("/salut")
    public String salut() {
        return "ça va ?";
    }

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public ResponseEntity<Response> push(@RequestBody Item item) {
        testService.doStuff(item.input);
        return ResponseEntity.ok(new Response(myGlobalState.getValue(), myRequestContext.modifiedInput));
    }

}
