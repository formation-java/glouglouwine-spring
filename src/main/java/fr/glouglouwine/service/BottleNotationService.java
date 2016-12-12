package fr.glouglouwine.service;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class BottleNotationService {

    @Async
    public void test() {
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        Future<Response> f = asyncHttpClient.prepareGet("http://localhost:8082/").execute();
        
    }

}
