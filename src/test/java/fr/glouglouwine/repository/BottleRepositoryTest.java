package fr.glouglouwine.repository;

import fr.glouglouwine.dto.Bottle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// This is useless here, and just slows down the test running =)
// @RunWith(SpringRunner.class)
// @SpringBootTest
public class BottleRepositoryTest {

    private BottleRepository bottleRepository = new BottleRepository();

    @Test
    public void test() throws Exception {
        Bottle bottle = new Bottle(1L, "Saulnoz", "Chateau Lapompe");

        assertEquals(0, bottleRepository.getAll().size());

        bottleRepository.create(bottle);

        assertEquals(1, bottleRepository.getAll().size());
        // not autoboxing won't work here =(
        assertEquals(new Long(1L), bottleRepository.getAll().get(0));

        assertEquals("Saulnoz", bottleRepository.get(1L).getOwner());
        assertEquals("Chateau Lapompe", bottleRepository.get(1L).getDomain());
    }

}