package fr.glouglouwine.repository;

import fr.glouglouwine.GlouGlouWineApplication;
import fr.glouglouwine.domain.Bottle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GlouGlouWineApplication.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@ActiveProfiles("test")
@SpringBootTest
public class H2BottleRepositoryTest {

    @Inject
    private H2BottleRepository h2BottleRepository;

    @Test
    public void test() {
        List<Bottle> bottles = h2BottleRepository.fetchAll();
        assertEquals(3, bottles.size());
    }

}
