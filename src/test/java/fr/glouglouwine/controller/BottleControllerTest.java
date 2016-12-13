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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BottleControllerTest {

    private static Bottle bottle = new Bottle(1L, "Saulnoz", "Chateau Lapompe", LocalDateTime.of(2016, 11, 10, 19, 30, 47));
    private static Bottle bottle2 = new Bottle(2L, "Éric", "Chateau Réaut", LocalDateTime.of(2016, 10, 10, 19, 30, 47));

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BottleService bottleService;

    @Test
    public void testGetId() throws Exception {
        given(bottleService.get(1L)).willReturn(bottle);

        mvc.perform(get("/bottle/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // for your information only...
                .andExpect(content().string("{\"id\":1,\"owner\":\"Saulnoz\"" +
                        ",\"domain\":\"Chateau Lapompe\",\"openingDate\":\"2016-11-10T19:30:47\"}"))
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("owner", is("Saulnoz")))
                .andExpect(jsonPath("domain", is("Chateau Lapompe")))
                .andExpect(jsonPath("openingDate", is("2016-11-10T19:30:47")));
    }

    @Test
    public void testGetAll() throws Exception {
        given(bottleService.getAll()).willReturn(Arrays.asList(bottle, bottle2));

        mvc.perform(get("/bottle")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].owner", is("Saulnoz")))
                .andExpect(jsonPath("$[0].openingDate", is("2016-11-10T19:30:47")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].owner", is("Éric")))
                .andExpect(jsonPath("$[1].openingDate", is("2016-10-10T19:30:47")));
    }


    @Test
    public void testPost() throws Exception {
        // our mock doesn't need to be "prepared" to be called
        Path jsonFilePath = Paths.get(getClass().getClassLoader().getResource("bottles.json").toURI());
        String jsonBottles = new String(Files.readAllBytes(jsonFilePath));
        mvc.perform(post("/bottle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBottles)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}