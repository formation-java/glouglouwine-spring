package fr.glouglouwine.service;

import fr.glouglouwine.dto.Bottle;
import fr.glouglouwine.repository.BottleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BottleServiceTest {

    @MockBean
    private BottleRepository bottleRepository;

    @Autowired
    private BottleService bottleService;

    @Test
    public void getAll() throws Exception {
        Bottle bottle = new Bottle(1, "Saulnoz", "Chateau truc");

        given(bottleRepository.getAll())
                .willReturn(new ArrayList<>(Arrays.asList(bottle.getId())));
        given(bottleRepository.get(1L))
                .willReturn(bottle);

        Assert.assertEquals(1, bottleService.getAll().size());
        Assert.assertEquals(bottle.getId(), bottleService.getAll().get(0).getId());
        Assert.assertEquals(bottle.getOwner(), bottleService.getAll().get(0).getOwner());
        Assert.assertEquals(bottle.getDomain(), bottleService.getAll().get(0).getDomain());
    }

}
