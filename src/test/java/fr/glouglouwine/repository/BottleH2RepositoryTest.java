package fr.glouglouwine.repository;

import fr.glouglouwine.dto.Bottle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BottleH2RepositoryTest {

    @Autowired
    @Qualifier("bottleH2Repository")
    private BottleRepository bottleRepository;

    @Test
    public void test() throws Exception {
        Bottle bottle = new Bottle(1L, "Saulnoz", "Chateau Lapompe", LocalDateTime.of(2016, 11, 10, 19, 30, 47));

        assertEquals(0, bottleRepository.getAll().size());

        bottleRepository.create(bottle);

        assertEquals(1, bottleRepository.getAll().size());
        // not autoboxing won't work here =(
        assertEquals(new Long(1L), bottleRepository.getAll().get(0));

        assertEquals("Saulnoz", bottleRepository.get(1L).getOwner());
        assertEquals("Chateau Lapompe", bottleRepository.get(1L).getDomain());
    }

}