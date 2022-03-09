package com.application.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Promotion")
public class Promotion {

	@JsonIgnore
	@EmbeddedId
	private PromotionPK id;
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant Enseignant;

	private String sigle_Promotion;

	private int nb_Max_Etudiant;

	private String date_Reponse_Lp;

	private String date_Reponse_Lalp;

	private String date_Rentree;

	private String lieu_Rentree;

	private String processus_Stage;

	private String commentaire;
}
