package fr.glouglouwine.service;

import fr.glouglouwine.context.ApplicationGlobalState;
import fr.glouglouwine.context.UserRequestContext;
import fr.glouglouwine.context.UserSession;
import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.repository.BottleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class BottleService {

    @Inject
    private BottleRepository bottleRepository;

    @Inject
    private ApplicationGlobalState applicationGlobalState;
    @Inject
    private UserSession userSession;
    @Inject
    private UserRequestContext userRequestContext;

    @Transactional(readOnly = true)
    public List<Bottle> fetchAll() {
        return bottleRepository.fetchAll();
    }

    @Transactional
    public void addBottles(List<Bottle> bottles) {
        applicationGlobalState.addBottles(bottles.size());
        userSession.addBottles(bottles.size());
        userRequestContext.addBottles(bottles.size());
        for (Bottle t : bottles) {
            bottleRepository.addBlotte(t);
        }
    }

}