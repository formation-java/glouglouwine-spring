package fr.glouglouwine.repository;

import fr.glouglouwine.domain.Bottle;

import java.util.List;

public interface BottleRepository {
    public abstract void addBlotte(Bottle bottle);

    public abstract List<Bottle> fetchAll();
}
