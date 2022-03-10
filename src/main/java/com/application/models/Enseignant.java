package com.application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Enseignant")
public class Enseignant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long no_Enseignant;
	private String nom;
	private String prenom;
	private Sexe sexe;
	private TypeEnseignant type;
	private String pays;
	private String ville;
	private String adresse;	
	private String email_Perso;
	private String email_Ubo;
	private String mobile;
	private String telephone;
	private String code_Postal;
}
