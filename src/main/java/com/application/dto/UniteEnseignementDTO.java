package com.application.dto;

import com.application.models.Enseignant;
import com.application.models.UniteEnseignementPK;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UniteEnseignementDTO {

    private UniteEnseignementPK id;

    private Enseignant enseignant;

    @NotBlank(message = "Le champs est obligatoire.")
    @Size(min = 1, max = 64, message = "Le champs ne doit pas dépasser 64 caractères.")
    private String designation;

    @NotBlank(message = "Le champs est obligatoire.")
    @Size(min = 1, max = 3, message = "Le champs ne doit pas dépasser 255 caractères.")
    private String semestre;

    @Size(min = 0, max = 255, message = "Le champs ne doit pas dépasser 255 caractères.")
    private String description;

    private int nbh_cm;

    private int nbh_td;

    private int nbh_tp;

    private double nbh_etd;
}
