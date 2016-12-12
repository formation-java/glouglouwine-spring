package fr.glouglouwine.repository;

import fr.glouglouwine.dto.Bottle;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BottleRepository {

    private ConcurrentHashMap<Long, Bottle> bottles = new ConcurrentHashMap<>();

    public void create(Bottle bottle) {
        bottles.put(bottle.getId(), bottle);
    }

    public Bottle get(Long id) {
        return bottles.get(id);
    }

    public List<Long> getAll() {
        return Collections.list(bottles.keys());
        // More ?
        // return bottles.values().stream().map(b -> b.getId()).collect(Collectors.toList());
        // return bottles.entrySet().stream().map(b -> b.getValue().getId()).collect(Collectors.toList());
    }

}
