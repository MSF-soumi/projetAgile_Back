package com.application.dto;

import com.application.models.Enseignant;
import com.application.models.ProcessusStage;
import com.application.models.PromotionPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PromotionDTO {

    private PromotionPK id;

    private Enseignant Enseignant;

    @NotBlank(message = "Le sigle de la promotion est obligatoire")
    @Size(min = 1, max = 16, message = "Le Sigle Promotion ne doit pas dépasser 16 caractères")
    private String sigle_Promotion;

    @NotNull(message = "Le nombre max des étudiants est obligatoire")
    @Min(value = 1, message = "Le nombre max des étudiants ne peut pas être inférieur à 1")
    @Max(value = 999, message = "Le nombre max des étudiants ne peut pas être supérieur à 999")
    private int nb_Max_Etudiant;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de réponse de la liste principale est obligatoire")
    private LocalDate date_Reponse_Lp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de réponse de la liste d'attente est obligatoire")
    private LocalDate date_Reponse_Lalp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de rentrée est obligatoire")
    private LocalDate date_Rentree;

    @NotBlank(message = "Le lieu de rentrée est obligatoire")
    private String lieu_Rentree;
    private String processus_Stage;
    private String commentaire;
}
