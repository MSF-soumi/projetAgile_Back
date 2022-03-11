package com.application.dto;

import com.application.models.Enseignant;
import com.application.models.ProcessusStage;
import com.application.models.PromotionPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PromotionDTO {

    private PromotionPK id;

    private Enseignant Enseignant;

    @NotBlank(message = "Le sigle Promotion est obligatoire")
    private String sigle_Promotion;

    @NotNull(message = "Le nombre max des etudiants est obligatoire")
    private int nb_Max_Etudiant;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de reponse de la liste principale est obligatoire")
    private LocalDate date_Reponse_Lp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de reponse de la liste d'attente est obligatoire")
    private LocalDate date_Reponse_Lalp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de rentrée est obligatoire")
    private LocalDate date_Rentree;

    @NotBlank(message = "Le lieu de rentrée est obligatoire")
    private String lieu_Rentree;
    private String processus_Stage;
    private String commentaire;
}
