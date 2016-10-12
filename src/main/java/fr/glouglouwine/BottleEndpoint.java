package fr.glouglouwine;

import fr.glouglouwine.domain.AddBottleResponse;
import fr.glouglouwine.domain.Bottle;
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
    private ApplicationGlobalState glouGlouGlobalState;
    @Autowired
    private UserRequestContext myRequestContext;

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
        return ResponseEntity.ok(new AddBottleResponse(glouGlouGlobalState.getValue(), myRequestContext.addedBottles));
    }

}
