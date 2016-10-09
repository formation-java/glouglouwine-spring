package com.example;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class MyRequestContext {

    public int modifiedInput = 0;

}
