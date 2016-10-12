package fr.glouglouwine.service;

import fr.glouglouwine.context.ApplicationGlobalState;
import fr.glouglouwine.context.UserRequestContext;
import fr.glouglouwine.context.UserSession;
import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.repository.BottleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BottleService {

    @Autowired
    private BottleRepository bottleRepository;

    @Autowired
    private ApplicationGlobalState applicationGlobalState;
    @Autowired
    private UserSession userSession;
    @Autowired
    private UserRequestContext userRequestContext;

    // TODO prefer fetch word
    // TODO rajouter transaction
    @Transactional(readOnly = true)
    public List<Bottle> fetchAll() {
        return bottleRepository.fetchAll();
    }

    @Transactional
    public void addBottles(List<Bottle> bottles) {
    applicationGlobalState.addBottles(bottles.size());
    userSession.addBottles(bottles.size());
    userRequestContext.addBottles(bottles.size());
        bottles.stream().forEach(bottleRepository::addBlotte);
    }

}
