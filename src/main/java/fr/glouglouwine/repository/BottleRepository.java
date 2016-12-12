package fr.glouglouwine.repository;

import fr.glouglouwine.dto.Bottle;

import java.util.List;

public interface BottleRepository {

    void create(Bottle bottle);

    Bottle get(Long id);

    List<Bottle> getAll();
    
}
