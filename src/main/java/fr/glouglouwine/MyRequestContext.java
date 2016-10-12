package fr.glouglouwine;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyRequestContext implements ContextInterface {

    private int modifiedInput = 0;

    @Override
    public int getModifiedInput() {
        return modifiedInput;
    }

    @Override
    public void setModifiedInput(int modifiedInput) {
        this.modifiedInput = modifiedInput;
    }
}
