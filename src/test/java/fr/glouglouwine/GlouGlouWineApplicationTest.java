package fr.glouglouwine;

import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.repository.H2BottleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlouGlouWineApplicationTest {

	@Inject
	private H2BottleRepository h2BottleRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() {
		List<Bottle> bottles = h2BottleRepository.fetchAll();
		assertEquals(3, bottles.size());
	}
}
