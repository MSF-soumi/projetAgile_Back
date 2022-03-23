package com.application.dto;

import com.application.models.Enseignant;
import com.application.models.UniteEnseignementPK;
import lombok.Data;

@Data
public class UniteEnseignementDTO {

    private UniteEnseignementPK id;

    private Enseignant enseignant;

    private String designation;

    private String semestre;

    private String description;

    private int nbh_cm;

    private int nbh_td;

    private int nbh_tp;

    private double nbh_etd;
}
