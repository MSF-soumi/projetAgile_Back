package com.application.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Promotion")
public class Promotion implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PromotionPK id;

	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant Enseignant;

//	@OneToMany(mappedBy="promotion",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Set<Etudiant> etudiants=new HashSet<>();

	private String sigle_Promotion;

	private int nb_Max_Etudiant;

	private LocalDate date_Reponse_Lp;

	private LocalDate date_Reponse_Lalp;

	private LocalDate date_Rentree;

	private String lieu_Rentree;

	@Transient
	private Set<Etudiant> etudiantSet= new HashSet<>();
	
	@Transient
	private Set<UniteEnseignement> uniteEnseignementSet = new HashSet<>();


	private String processus_Stage;

	private String commentaire;


	
}
