package com.application.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EnseignantControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    void contextLoads() {
    }

    /*Test for 200 status*/
    @Test
    public void getAllEnseignants() throws Exception{
    mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/enseignants")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
    @Test
    public void getAllEnseignantById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/enseignants/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    public void getAllEnseignantByEmail() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/enseignants/emailUbo/"+"ps@univ-brest.fr")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    //remarque sur la taille de pays max=5!!!
    @Test
    public void createEnseignant() throws Exception{

        Object randomObj = new Object() {
            public final String nom = "saliouTest";
            public final String prenom="philipeTest";
            public final String sexe="H";
            public final String type="DF";
            public final String pays="F";
            public final String ville="Brest";
            public final String adresse="6 rue de l'eglise";
            public final String email_Perso="philipeTestPerso@gmail.com";
            public final String email_Ubo="philipeTestUbo@univ-brest.fr";
            public final String mobile="06.00.00.01.00";
            public final String telephone="02.98.01.69.74";
            public final String code_Postal="29860";
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);
        System.out.println(json);
        mvc.perform(MockMvcRequestBuilders.post("http://localhost:9191/api/v1/enseignants")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(json)
                .characterEncoding("utf-8")).andExpect(status().isOk());

    }

    @Test
    public void deleteEnseignant() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:9191/api/v1/enseignants/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    /*Tests for 500 status*/
    @Test
    public void getAllEnseignants_badRequest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/enseignant")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());

    }
    @Test
    public void getAllEnseignantById_notFound() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/enseignants/10")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
                //.andExpect(status().reason(containsString("ID not found")));

    }
    @Test
    public void getAllEnseignantByEmail_notFound() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/enseignants/emailUbo/"+"notFound@univ-brest.fr")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());

    }

    @Test
    public void deleteEnseignant_notFound() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:9191/api/v1/enseignants/111")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());

    }
}
