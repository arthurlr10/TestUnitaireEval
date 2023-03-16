package com.epsi.evaltest;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        mockMvc.perform(post("/game/restart"));
    }

    @Test
    public void testPlayGame() throws Exception {
        MvcResult result = mockMvc.perform(get("/game/play/pierre"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertThat(content).contains("Vous avez joué pierre. L'ordinateur a joué");

        result = mockMvc.perform(get("/game/play/feuille"))
                .andExpect(status().isOk())
                .andReturn();
        content = result.getResponse().getContentAsString();
        assertThat(content).contains("Vous avez joué feuille. L'ordinateur a joué");

        result = mockMvc.perform(get("/game/play/ciseaux"))
                .andExpect(status().isOk())
                .andReturn();
        content = result.getResponse().getContentAsString();
        assertThat(content).contains("Vous avez joué ciseaux. L'ordinateur a joué");
    }

}
