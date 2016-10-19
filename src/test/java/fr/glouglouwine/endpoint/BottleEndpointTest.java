package fr.glouglouwine.endpoint;


import fr.glouglouwine.domain.Bottle;
import fr.glouglouwine.domain.GrapeTypes;
import fr.glouglouwine.service.BottleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(BottleEndpoint.class)
public class BottleEndpointTest {

    @Inject
    private MockMvc mvc;

    @MockBean
    private BottleService bottleService;

    @Test
    public void getVehicleShouldReturnMakeAndModel() throws Exception {
        Bottle bottle = new Bottle(1, "Saulnoz", GrapeTypes.MALBEC, "Chateau truc", "1979",
                100, null, null);

        given(bottleService.fetchAll())
                .willReturn(new ArrayList<>(Arrays.asList(bottle)));

        mvc.perform(get("/bottle")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"owner\":\"Saulnoz\",\"grapeType\":\"MALBEC\"," +
                        "\"domain\":\"Chateau truc\",\"year\":\"1979\",\"quantity\":100.0,\"openingDate\":null," +
                        "\"finishingDate\":null}]"));
    }
}
