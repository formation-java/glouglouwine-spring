package fr.glouglouwine.context;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {

    private AtomicInteger addedBottles = new AtomicInteger(0);

    public int getAddedBottles() {
        return addedBottles.get();
    }

    public void addBottles(int number) {
        addedBottles.addAndGet(number);
    }

}
