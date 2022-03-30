package com.application.dto;

import com.application.models.Enseignant;
import com.application.models.ProcessusStage;
import com.application.models.PromotionPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class PromotionDTO {

    private PromotionPK id;

    private Enseignant Enseignant;

    @NotBlank(message = "Ce champs est obligatoire.")
    @Size(min = 1, max = 16, message = "Ce champs ne peut pas dépasser 16 caractères.")
    private String sigle_Promotion;

    @NotNull(message = "Ce champs est obligatoire.")
    @Min(value = 1, message = "Le nombre maximum des étudiants ne peut pas être inférieur à 1.")
    @Max(value = 999, message = "Le nombre maximum des étudiants ne peut pas être supérieur à 999.")
    private int nb_Max_Etudiant;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "Ce champs est obligatoire.")
    private LocalDate date_Reponse_Lp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "Ce champs est obligatoire.")
    private LocalDate date_Reponse_Lalp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "LCe champs est obligatoire.")
    private LocalDate date_Rentree;

    @NotBlank(message = "Ce champs est obligatoire.")
    private String lieu_Rentree;
    private Set<UniteEnseignementDTO> uniteEnseignementSet = new HashSet<>();
    private Set<EtudiantDTO> etudiantSet = new HashSet<>();
    private String processus_Stage;
    private String commentaire;
}
