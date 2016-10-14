package fr.glouglouwine.service;

import fr.glouglouwine.GlouGlouWineTestContext;
import fr.glouglouwine.domain.Bottle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GlouGlouWineTestContext.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@ActiveProfiles("test")
@SpringBootTest
public class BottleServiceTest {

    @Autowired
    private BottleService bottleService;

    @Test
    public void test() {
        Bottle bottle = new Bottle();
        bottleService.addBottles(Arrays.asList(bottle));
        Assert.assertEquals(bottle, bottleService.fetchAll().get(0));
    }
}
