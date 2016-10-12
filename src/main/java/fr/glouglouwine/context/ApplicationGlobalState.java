package fr.glouglouwine.context;

import org.springframework.stereotype.Component;

@Component
public class ApplicationGlobalState {

    private int totalBottlesAdded = 0;

    public int getTotalBottlesAdded() {
        return totalBottlesAdded;
    }

    public synchronized void addBottles(int number) {
        this.totalBottlesAdded += number;
    }
}
