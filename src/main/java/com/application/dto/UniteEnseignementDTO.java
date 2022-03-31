package com.application.dto;

import com.application.models.Enseignant;
import com.application.models.UniteEnseignementPK;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UniteEnseignementDTO {

    private UniteEnseignementPK id;

    private Enseignant enseignant;

    @NotBlank(message = "Ce champs est obligatoire.")
    @Size(min = 1, max = 64, message = "Ce champs ne doit pas dépasser 64 caractères.")
    private String designation;

    @NotBlank(message = "Ce champs est obligatoire.")
    @Size(min = 1, max = 3, message = "Ce champs ne doit pas dépasser 255 caractères.")
    private String semestre;

    @Size(min = 0, max = 255, message = "Ce champs ne doit pas dépasser 255 caractères.")
    private String description;

    //@Pattern(regexp="^[0-9]$", message="Ce champs doit être un nombre.")
    private int nbh_Cm;

    //@Pattern(regexp="^[0-9]{1,2}$", message="Ce champs ne doit pas dépasser 3 chiffres.")
    private int nbh_Td;

    //@Pattern(regexp="^[0-9]{1,2}$", message="Ce champs ne doit pas dépasser 3 chiffres.")
    private int nbh_Tp;

    private double nbh_Etd;
}
