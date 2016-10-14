package fr.glouglouwine.service;

import fr.glouglouwine.GlouGlouWineApplication;
import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.repository.BottleRepository;
import fr.glouglouwine.repository.TestBottleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Arrays;

import static fr.glouglouwine.domain.GrapeTypes.MALBEC;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BottleServiceTest {

    @Configuration
    static class ContextConfiguration extends GlouGlouWineApplication {
        @Bean
        public BottleRepository bottleRepository() {
            return new TestBottleRepository();
        }
    }

//    @MockBean
    @Inject
    private BottleService bottleService;

    @Test
    public void test() {
        Bottle bottle = new Bottle(1, "Saulnoz", MALBEC, "Chateau truc", 1979,
                100,null, null);
        bottleService.addBottles(Arrays.asList(bottle));
        Assert.assertEquals(bottle.getId(), bottleService.fetchAll().get(0).getId());
    }
}
