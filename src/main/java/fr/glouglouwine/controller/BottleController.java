package fr.glouglouwine.controller;

import fr.glouglouwine.dto.Bottle;
import fr.glouglouwine.service.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/bottle")
public class BottleController {

    @Autowired
    private BottleService bottleService;

    @RequestMapping("/{id}")
    public Bottle get(@PathVariable Long id) {
        return bottleService.get(id);
    }

    @RequestMapping()
    public List<Bottle> getAll() {
        return bottleService.getAll();
    }

    @RequestMapping(method = POST)
    public void create(@RequestBody List<Bottle> bottles) {
        bottleService.create(bottles);
    }

}
