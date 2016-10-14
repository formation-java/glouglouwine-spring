package fr.glouglouwine.repository;

import fr.glouglouwine.domain.Bottle;

import java.util.List;

public interface BottleRepository {
    void addBlotte(Bottle bottle);

    List<Bottle> fetchAll();
}
