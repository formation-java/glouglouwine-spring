package fr.glouglouwine.controller;

import fr.glouglouwine.dto.Bottle;
import fr.glouglouwine.service.BottleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BottleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BottleService bottleService;

    @Test
    public void testGetId() throws Exception {
        Bottle bottle = new Bottle(1L, "Saulnoz", "Chateau Lapompe");

        given(bottleService.get(1L)).willReturn(bottle);

        mvc.perform(get("/bottle/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // for your information only...
                .andExpect(content().string("{\"id\":1,\"owner\":\"Saulnoz\"" +
                        ",\"domain\":\"Chateau Lapompe\",\"openingDate\":null}"))
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("owner", is("Saulnoz")))
                .andExpect(jsonPath("domain", is("Chateau Lapompe")));
    }

}