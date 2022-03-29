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

    @NotBlank(message = "Le sigle de la promotion doit être renseigné.")
    @Size(min = 1, max = 16, message = "Le sigle Promotion ne doit pas dépasser 16 caractères.")
    private String sigle_Promotion;

    @NotNull(message = "Le nombre maximum des étudiants doit être renseigné.")
    @Min(value = 1, message = "Le nombre maximum des étudiants ne peut pas être inférieur à 1.")
    @Max(value = 999, message = "Le nombre maximum des étudiants ne peut pas être supérieur à 999.")
    private int nb_Max_Etudiant;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de réponse à la liste principale doit être renseignée.")
    private LocalDate date_Reponse_Lp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de réponse à la liste d'attente doit être renseignée.")
    private LocalDate date_Reponse_Lalp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "La date de rentrée doit être rensiegnée.")
    private LocalDate date_Rentree;

    @NotBlank(message = "Le lieu de rentrée doit être renseigné.")
    private String lieu_Rentree;
    private Set<UniteEnseignementDTO> uniteEnseignementSet = new HashSet<>();
    private Set<EtudiantDTO> etudiantSet = new HashSet<>();
    private String processus_Stage;
    private String commentaire;
}
