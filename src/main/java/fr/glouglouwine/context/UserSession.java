package fr.glouglouwine.context;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {

    private int addedBottles = 0;

    public int getAddedBottles() {
        return addedBottles;
    }

    public synchronized void addBottles(int number) {
        this.addedBottles += number;
    }

}
