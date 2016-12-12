package fr.glouglouwine.service;

import fr.glouglouwine.dto.Bottle;
import fr.glouglouwine.repository.BottleHashmapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BottleService {

    private static final Logger logger = LoggerFactory.getLogger(BottleService.class);

    @Autowired
    private BottleHashmapRepository bottleRepository;

    public List<Bottle> getAll() {
        List<Long> ids = bottleRepository.getAll();
        List<Bottle> bottles = new ArrayList<>();
        for (Long id : ids) {
            bottles.add(bottleRepository.get(id));
        }
        return bottles;
        // More ?
        // return bottleRepository.getAll().stream().map(bottleRepository::get).collect(Collectors.toList());
    }

    public void create(List<Bottle> bottles) {
        for (Bottle b : bottles) {
            bottleRepository.create(b);
        }
        // More ?
        // bottles.stream().forEach(bottleRepository::create);
    }

}
