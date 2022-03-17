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
    public void getAllPromotions() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/promotions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getPromotionById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:9191/api/v1/promotions/M2DOSI/2013-2014")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


    @Test
    public void createPromotion() throws Exception {

        String newPromotion = "{\"id\":" +
                "{\"code_Formation\": \"M2DOSI\"," +
                "\"annee_Universitaire\": \"2015-2016\"}," +
                "\"sigle_Promotion\": \"DOSI2016\","+
                "\"nb_Max_Etudiant\":\"50\"," +
                "\"date_Reponse_Lp\":\"04-05-13\"," +
                "\"date_Reponse_Lalp\":\"19-05-13\"," +
                "\"date_Rentree\":\"07-09-13\"," +
                "\"lieu_Rentree\":\"LC117B\"," +
                "\"processus_Stage\": null," +
                "\"commentaire\":\"Commentaire Test\"," +
                "\"enseignant\": {" +
                    "\"no_Enseignant\": 1," +
                    "\"nom\": \"SALIOU\"," +
                    "\"prenom\": \"Philippe\"," +
                    "\"sexe\": \"H\"," +
                    "\"type\": \"MCF\"," +
                    "\"pays\": \"FR\"," +
                    "\"ville\": \"LE DRENNEC\"," +
                    "\"adresse\": \"6 rue de l'eglise\"," +
                    "\"email_Perso\": \"philippe.saliou@gmail.com\"," +
                    "\"email_Ubo\": \"philippe.saliou@univ-brest.fr\"," +
                    "\"mobile\": \"+33600000100\"," +
                    "\"telephone\": \"+33298016974\"," +
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
                "\"annee_Universitaire\": \"2012-2013\"}," +
                "\"sigle_Promotion\": \"DOSI13\","+
                "\"nb_Max_Etudiant\":\"50\"," +
                "\"date_Reponse_Lp\":\"04-05-13\"," +
                "\"date_Reponse_Lalp\":\"19-05-13\"," +
                "\"date_Rentree\":\"07-09-13\"," +
                "\"lieu_Rentree\":\"LC117B\"," +
                "\"processus_Stage\": \"RECH\"," +
                "\"commentaire\":\"Commentaire Test\"" +
                "}";

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:9191/api/v1/promotions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(newPromotion)
                .characterEncoding("utf-8")).andExpect(status().isOk());
    }

    @Test
    public void deletePromotion() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:9191/api/v1/promotions/M2DOSI/2010-2011")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}
