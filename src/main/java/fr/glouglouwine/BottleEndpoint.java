package fr.glouglouwine;

import fr.glouglouwine.domain.Bottle;
import org.springframework.http.HttpStatus;
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

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("bottles")
    public List<Bottle> bottles() {
        return bottleService.fetchAll();
    }

    @RequestMapping(value = "bottles", method = RequestMethod.POST)
    public ResponseEntity<Void> asc(@RequestBody List<Bottle> bottles) {
        bottleService.addBottles(bottles);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
