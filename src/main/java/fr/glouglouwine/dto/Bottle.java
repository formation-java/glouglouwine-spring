package fr.glouglouwine.dto;

import java.time.LocalDateTime;

public class Bottle {

    private long id;
    private String owner;
    private String domain;
    private LocalDateTime openingDate;

    Bottle() {
    }

    public Bottle(long id, String owner, String domain) {
        this.id = id;
        this.owner = owner;
        this.domain = domain;
    }

    public Bottle(long id, String owner, String domain, LocalDateTime openingDate) {
        this.id = id;
        this.owner = owner;
        this.domain = domain;
        this.openingDate = openingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }
}
