package com.application.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Unite_enseignement")
public class UniteEnseignement implements Serializable {
    private static final long serialVersionID = 1L;

    @EmbeddedId
    private UniteEnseignementPK id;

    @ManyToOne
    @JoinColumn(name="NO_ENSEIGNANT")
    private Enseignant enseignant;

    private String designation;

    private String semestre;

    private String description;

    private int nbh_Cm;

    private int nbh_Td;

    private int nbh_Tp;

    @Transient
    private double nbh_Etd;

    @PostLoad
    private void postLoad() {
        if(this.enseignant.getType().getCode().equals("MCF")) {
            this.nbh_Etd = this.nbh_Cm * 1.5 + this.nbh_Td + (double)this.nbh_Tp * 2/3;
        } else {
            this.nbh_Etd = this.nbh_Cm * 1.5 + this.nbh_Td + (double)this.nbh_Tp;
        }
        this.nbh_Etd = Math.round(this.nbh_Etd * 2) / 2.0;
    }

    public double getNbhEtd() {
        return this.nbh_Etd;
    }

}
