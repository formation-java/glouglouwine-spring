package fr.glouglouwine;

import fr.glouglouwine.domain.Bottle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BottleService {

    @Autowired
    private ApplicationGlobalState glouGlouGlobalState;

    @Autowired
    private UserRequestContext userRequestContext;

    @Autowired
    private UserSession glouGlouSession;

    @Autowired
    private BottleRepository bottleRepository;

    // TODO prefer fetch word
    // TODO rajouter transaction
    @Transactional(readOnly = true)
    public List<Bottle> fetchAll() {
        return bottleRepository.fetchAll();
    }

    @Transactional
    public void addBottles(List<Bottle> bottles) {
        bottles.stream().forEach(bottleRepository::addBlotte);
    }

}
