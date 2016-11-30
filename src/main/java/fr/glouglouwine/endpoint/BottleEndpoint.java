package fr.glouglouwine.endpoint;

import fr.glouglouwine.context.ApplicationGlobalState;
import fr.glouglouwine.context.UserRequestContext;
import fr.glouglouwine.context.UserSession;
import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.dto.AddBottleResponse;
import fr.glouglouwine.service.BottleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class BottleEndpoint {

    @Inject
    private BottleService bottleService;

    @Inject
    private ApplicationGlobalState applicationGlobalState;
    @Inject
    private UserSession userSession;
    @Inject
    private UserRequestContext userRequestContext;

    @RequestMapping("/")
    public String glouGlou() {
        return "glou glou";
    }

    @RequestMapping("/bottles")
    public List<Bottle> getBottles() {
        return bottleService.fetchAll();
    }

    @RequestMapping(value = "/bottles", method = RequestMethod.POST)
    public ResponseEntity<AddBottleResponse> addBottle(@RequestBody List<Bottle> bottles) {
        bottleService.addBottles(bottles);
        return ResponseEntity.ok(new AddBottleResponse(applicationGlobalState.getTotalBottlesAdded(),
                userSession.getAddedBottles(), userRequestContext.getAddedBottles()));
    }

}
