package fr.glouglouwine.context;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ApplicationGlobalState {

    private AtomicInteger totalBottlesAdded = new AtomicInteger(0);

    public int getTotalBottlesAdded() {
        return totalBottlesAdded.get();
    }

    public void addBottles(int number) {
        totalBottlesAdded.addAndGet(number);
    }
}
