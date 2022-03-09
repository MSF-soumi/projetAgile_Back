package com.application.dto;

import com.application.models.Enseignant;
import com.application.models.PromotionPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class PromotionDTO {

    private PromotionPK id;

    private Enseignant Enseignant;

    @NotBlank(message = "Le sigle Promotion est obligatoire")
    private String sigle_Promotion;

    @NotBlank(message = "Le nombre max des etudiants est obligatoire")
    private int nb_Max_Etudiant;

    @NotBlank(message = "La date de reponse de la liste principale est obligatoire")
    private String date_Reponse_Lp;

    @NotBlank(message = "La date de reponse de la liste d'attente est obligatoire")
    private String date_Reponse_Lalp;

    @NotBlank(message = "La date de rentrée est obligatoire")
    private String date_Rentree;

    @NotBlank(message = "Le lieu de rentrée est obligatoire")
    private String lieu_Rentree;
    private String processus_Stage;
    private String commentaire;
}
