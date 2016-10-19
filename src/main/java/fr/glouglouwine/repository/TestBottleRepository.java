package fr.glouglouwine.repository;

import fr.glouglouwine.domain.Bottle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBottleRepository implements BottleRepository {

    private List<Bottle> bottles = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void addBottle(Bottle bottle) {
        bottles.add(bottle);
    }

    @Override
    public List<Bottle> fetchAll() {
        return bottles;
    }
}
