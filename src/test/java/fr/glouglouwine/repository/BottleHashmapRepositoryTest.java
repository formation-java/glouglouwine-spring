package fr.glouglouwine.repository;

import fr.glouglouwine.dto.Bottle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BottleHashmapRepositoryTest {

    private BottleHashmapRepository bottleRepository = new BottleHashmapRepository();

    @Test
    public void test() throws Exception {
        Bottle bottle = new Bottle(1L, "Saulnoz", "Chateau Lapompe");

        assertEquals(0, bottleRepository.getAll().size());

        bottleRepository.create(bottle);

        assertEquals(1, bottleRepository.getAll().size());
        assertEquals(1L, bottleRepository.getAll().get(0).getId());

        assertEquals("Saulnoz", bottleRepository.get(1L).getOwner());
        assertEquals("Chateau Lapompe", bottleRepository.get(1L).getDomain());
    }

}