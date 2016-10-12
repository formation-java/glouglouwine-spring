package fr.glouglouwine.dto;

public class AddBottleResponse {

    public int totalAddedBottles;
    public int sessionAddedBottles;
    public int requestAddedBottles;

    public AddBottleResponse(int totalAddedBottles, int sessionAddedBottles, int requestAddedBottles) {
        this.totalAddedBottles = totalAddedBottles;
        this.sessionAddedBottles = sessionAddedBottles;
        this.requestAddedBottles = requestAddedBottles;
    }
}
