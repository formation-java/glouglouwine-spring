package fr.glouglouwine.domain;

public class AddBottleResponse {

    public int global;
    public int requestContext;

    public AddBottleResponse(int global, int requestContext) {
        this.global = global;
        this.requestContext = requestContext;
    }
}
