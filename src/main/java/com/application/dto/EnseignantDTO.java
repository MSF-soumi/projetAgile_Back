package com.application.dto;

import lombok.Data;

@Data
public class EnseignantDTO {
	private int no_Enseignant;
	private String nom;
	private String prenom;
	private String sexe;
	private String type;
	private String pays;
	private String ville;
	private String adresse;	
	private String email_Perso;
	private String email_Ubo;
	private String mobile;
	private String telephone;
	private String code_Postal;

}
