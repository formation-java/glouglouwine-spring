package fr.glouglouwine.repository;

import fr.glouglouwine.dto.Bottle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BottleHashmapRepository {

    private ConcurrentHashMap<Long, Bottle> bottles = new ConcurrentHashMap<>();

    public void create(Bottle bottle) {
        bottles.put(bottle.getId(), bottle);
    }

    public Bottle get(Long id) {
        return bottles.get(id);
    }

    public List<Bottle> getAll() {
        return new ArrayList(bottles.values());
    }

}
