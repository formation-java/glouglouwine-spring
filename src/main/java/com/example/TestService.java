package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private MyGlobalState myGlobalState;

    @Autowired
    private MyRequestContext requestContext;

    public void doStuff(int input) {
        myGlobalState.setValue(myGlobalState.getValue() + input);
        requestContext.setModifiedInput(requestContext.getModifiedInput() + input);
    }

}
