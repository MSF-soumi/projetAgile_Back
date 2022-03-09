package com.application.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Promotion")
public class Promotion implements Serializable {

	@EmbeddedId
	private PromotionPK id;

	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant Enseignant;

	private String sigle_Promotion;

	private int nb_Max_Etudiant;

	private LocalDate date_Reponse_Lp;

	private LocalDate date_Reponse_Lalp;

	private LocalDate date_Rentree;

	private String lieu_Rentree;

	private String processus_Stage;

	private String commentaire;
}
