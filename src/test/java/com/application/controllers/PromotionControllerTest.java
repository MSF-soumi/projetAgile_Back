package com.application.controllers;


import com.application.models.Enseignant;
import com.application.models.ProcessusStage;
import com.application.models.Promotion;
import com.application.models.PromotionPK;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PromotionControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    void contextLoads() {
    }

    @Test
    public void getAllPromotions() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/promotions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    //TODO
    @Test
    public void getPromotionById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/promotions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void createPromotion() throws Exception{

        Promotion newPromotion = new Promotion(
                new PromotionPK("DOSI2022","2021-2022"),
                new Enseignant(null, "saliouTest", "philipeTest", "H","DF", "France", "Brest", "2 Rue des archives", "test@email.com", "testubo@gmail.com", "0687965241","0263524196", "235641"),
                "DOSITest",
                24,
                null,
                null,
                null,
                "LC117B",
                "RECH",
                "commentaire"
                );


        Object randomObj = new Object() {
            public final String sigle_Promotion = "DOSITest";
            public final String nb_Max_Etudiant="50";
            public final String date_Reponse_Lp="04-05-13";
            public final String date_Reponse_Lalp="19-05-13";
            public final String date_Rentree="07-09-13";
            public final String lieu_Rentree="LC117B";
            public final String processus_Stage="EC";
            public final String commentaire="Commentaire Test";
        };

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        String json = objectMapper.writeValueAsString(newPromotion);
        System.out.println(json);
        mvc.perform(MockMvcRequestBuilders.post("http://localhost:9191/api/v1/promotions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(json)
                .characterEncoding("utf-8")).andExpect(status().isOk());
    }

    @Test
    public void deletePromotion() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:9191/api/v1/promotions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}
