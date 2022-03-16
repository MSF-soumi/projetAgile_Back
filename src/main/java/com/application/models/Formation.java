package com.application.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Formation")
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String code_Formation;
    private String diplome;
    private Long n0_Annee;
    private String nom_Formation;
    private String double_Diplome;
    private LocalDate debut_Accreditation;
    private LocalDate fin_Accreditation;
}
