package fr.glouglouwine.repository;

import fr.glouglouwine.domain.Bottle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class H2BottleRepositoryTest {

    @Inject
    private H2BottleRepository h2BottleRepository;

    @Test
    public void test() {
        List<Bottle> bottles = h2BottleRepository.fetchAll();
        assertEquals(0, bottles.size());
    }

}
