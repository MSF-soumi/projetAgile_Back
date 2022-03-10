package com.application.controllers;


import com.application.repositories.EnseignantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EnseignantControllerTest {

    @Autowired
    private MockMvc mvc;


    @Autowired
    private EnseignantRepository enseignantRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void getAllEnseignants() throws Exception{
    mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/enseignants")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}