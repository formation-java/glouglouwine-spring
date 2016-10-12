package fr.glouglouwine.endpoint;

import fr.glouglouwine.context.ApplicationGlobalState;
import fr.glouglouwine.context.UserRequestContext;
import fr.glouglouwine.context.UserSession;
import fr.glouglouwine.dto.AddBottleResponse;
import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.service.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class BottleEndpoint {

    @Autowired
    private BottleService bottleService;

    @Autowired
    private ApplicationGlobalState applicationGlobalState;
    @Autowired
    private UserSession userSession;
    @Autowired
    private UserRequestContext userRequestContext;

    @PostConstruct
    public void init() {
        System.out.println("salut ça va ?");
    }

    @RequestMapping("/")
    public String glouGlou() {
        return "glou glou";
    }

    @RequestMapping("/bottle")
    // TODO about jackson
    public List<Bottle> getBottles() {
        return bottleService.fetchAll();
    }

    @RequestMapping(value = "/bottle", method = RequestMethod.POST)
    public ResponseEntity<AddBottleResponse> addBottle(@RequestBody List<Bottle> bottles) {
        bottleService.addBottles(bottles);
        return ResponseEntity.ok(new AddBottleResponse(applicationGlobalState.getTotalBottlesAdded(),
                userSession.getAddedBottles(), userRequestContext.getAddedBottles()));
    }

}
