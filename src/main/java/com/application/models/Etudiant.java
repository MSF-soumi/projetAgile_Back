package com.application.models;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Etudiant")
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String no_Etudiant;

	@ManyToOne
	@JoinColumns({@JoinColumn(name="code_Formation",referencedColumnName ="code_Formation",insertable = false, updatable = false),
			@JoinColumn(name="annee_Universitaire",referencedColumnName="annee_Universitaire",insertable = false, updatable = false)})
	private Promotion promotion;

	private String code_Formation;
	private String annee_Universitaire;
	private String nom;
	private String prenom;
	private String sexe;
	private LocalDate date_Naissance;
	private String lieu_Naissance;
	private String nationalite;
	private String telephone;
	private String mobile;
	private String email;
	private String email_Ubo;
	private String adresse;
	private String code_Postal;
	private String ville;
	private String pays_Origine;
	private String universite_origine;
	private Long groupe_Tp;
	private Long groupe_Anglais;

}
