package fr.glouglouwine.repository;

import fr.glouglouwine.dto.Bottle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BottleHashmapRepository implements BottleRepository {

    private ConcurrentHashMap<Long, Bottle> bottles = new ConcurrentHashMap<>();

    @Override
    public void create(Bottle bottle) {
        bottles.put(bottle.getId(), bottle);
    }

    @Override
    public Bottle get(Long id) {
        return bottles.get(id);
    }

    @Override
    public List<Bottle> getAll() {
        return new ArrayList(bottles.values());
    }
}
