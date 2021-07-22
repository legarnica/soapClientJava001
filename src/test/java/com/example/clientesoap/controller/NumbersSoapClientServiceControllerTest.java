package com.example.clientesoap.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NumbersSoapClientServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NumbersSoapClientServiceController controller;

    /**
     * Test the transform number to literal representation of that number.
     *
     * @throws Exception if request fails.
     */
    @Test
    void getWordsOk() throws Exception {
        assertThat(controller).isNotNull();
        this.mockMvc.perform(get("/soapclient/towords?number=200"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("two hundred")));
    }
}