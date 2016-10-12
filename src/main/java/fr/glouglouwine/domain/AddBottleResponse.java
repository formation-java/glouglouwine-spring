package fr.glouglouwine.domain;

public class AddBottleResponse {

    public int addedBottles;
    public int totalBottles;

    public AddBottleResponse(int addedBottles, int totalBottles) {
        this.addedBottles = addedBottles;
        this.totalBottles = totalBottles;
    }
}
