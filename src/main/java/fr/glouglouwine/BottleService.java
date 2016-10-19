package fr.glouglouwine;

import fr.glouglouwine.domain.Bottle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class BottleService {

    @Inject
    private BottleRepository bottleRepository;

    @Transactional
    public void addBottles(List<Bottle> bottles) {
        for(Bottle b : bottles) {
            bottleRepository.addBottle(b);
        }
    }

    public List<Bottle> fetchAll() {
        return bottleRepository.fetchAll();
    }

}
