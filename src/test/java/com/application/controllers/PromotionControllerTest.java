package com.application.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


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
    public void getAllPromotionById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/promotions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


    @Test
    public void getPromotionById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/promotions/M2DOSI/2013-2014")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void createPromotion() throws Exception{

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

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:9191/api/v1/promotions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(json)
                .characterEncoding("utf-8")).andExpect(status().isOk());

        String newPromotion = "{\"id\":" +
                "{\"code_Formation\": \"M2DOSI\"," +
                "\"annee_Universitaire\": \"2014-2015\"}," +
                "\"sigle_Promotion\": \"DOSI2022\","+
                "\"nb_Max_Etudiant\":\"50\"," +
                "\"date_Reponse_Lp\":\"04-05-13\"," +
                "\"date_Reponse_Lalp\":\"19-05-13\"," +
                "\"date_Rentree\":\"07-09-13\"," +
                "\"lieu_Rentree\":\"LC117B\"," +
                "\"processus_Stage\": null," +
                "\"commentaire\":\"Commentaire Test\"," +
                "\"enseignant\": {" +
                    "\"no_Enseignant\": 1," +
                    "\"nom\": \"S\"," +
                    "\"prenom\": \"P\"," +
                    "\"sexe\": \"H\"," +
                    "\"type\": \"MCF\"," +
                    "\"pays\": \"FR\"," +
                    "\"ville\": \"LE DRENNEC\"," +
                    "\"adresse\": \"6 rue de l'eglise\"," +
                    "\"email_Perso\": \"ps@gmail.com\"," +
                    "\"email_Ubo\": \"ps@univ-brest.fr\"," +
                    "\"mobile\": \"06.00.00.01.00\"," +
                    "\"telephone\": \"02.98.01.69.74\"," +
                    "\"code_Postal\": \"29860\"" +
                "}"+
                "}";

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:9191/api/v1/promotions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(newPromotion)
                .characterEncoding("utf-8")).andExpect(status().isOk());
    }

    @Test
    public void createPromotionNoFK() throws Exception{
        String newPromotion = "{\"id\":" +
                "{\"code_Formation\": \"M2DOSI\"," +
                "\"annee_Universitaire\": \"2022-2023\"}," +
                "\"sigle_Promotion\": \"DOSI2022\","+
                "\"nb_Max_Etudiant\":\"50\"," +
                "\"date_Reponse_Lp\":\"04-05-13\"," +
                "\"date_Reponse_Lalp\":\"19-05-13\"," +
                "\"date_Rentree\":\"07-09-13\"," +
                "\"lieu_Rentree\":\"LC117B\"," +
                "\"processus_Stage\": null," +
                "\"commentaire\":\"Commentaire Test\"" +
                "}";

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:9191/api/v1/promotions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(newPromotion)
                .characterEncoding("utf-8")).andExpect(status().isOk());
    }

    @Test
    public void deletePromotion() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:9191/api/v1/promotions/M2DOSI/2022-2023")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}
