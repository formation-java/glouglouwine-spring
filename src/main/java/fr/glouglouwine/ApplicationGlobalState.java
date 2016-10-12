package fr.glouglouwine;

import org.springframework.stereotype.Service;

@Service
public class ApplicationGlobalState {

    private int value = 0;

    public int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
