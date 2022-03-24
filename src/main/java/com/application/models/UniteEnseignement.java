package com.application.models;

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

    private int nbh_cm;

    private int nbh_td;

    private int nbh_tp;

    @Transient
    private double nbh_etd;

    @PostLoad
    private void postLoad() {
        if(this.enseignant.getType().getCode().equals("MCF")) {
            this.nbh_etd = this.nbh_cm * 1.5 + this.nbh_td + (double)this.nbh_tp * 2/3;
        } else {
            this.nbh_etd = this.nbh_cm * 1.5 + this.nbh_td + (double)this.nbh_tp;
        }
        this.nbh_etd = Math.round(this.nbh_etd * 2) / 2.0;
    }

    public double getNbhEtd() {
        return this.nbh_etd;
    }

}
