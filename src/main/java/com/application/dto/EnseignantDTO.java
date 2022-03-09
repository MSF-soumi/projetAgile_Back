package com.application.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EnseignantDTO {
	
	private int no_Enseignant;
    @NotBlank(message = "Le nom Promotion est obligatoire")
	private String nom;
    @NotBlank(message = "Le prenom Promotion est obligatoire")
	private String prenom;
    @NotBlank(message = "Le sexe Promotion est obligatoire")
	private String sexe;
    @NotBlank(message = "Le sigle Promotion est obligatoire")
	private String type;
    @NotBlank(message = "Le type Promotion est obligatoire")
	private String pays;
    @NotBlank(message = "Le ville Promotion est obligatoire")
	private String ville;
    @NotBlank(message = "Le adresse Promotion est obligatoire")
	private String adresse;	
	private String email_Perso;
    @NotBlank(message = "L'email UBO Promotion est obligatoire")
	private String email_Ubo;
    @NotBlank(message = "Le mobile Promotion est obligatoire")
	private String mobile;
    @NotBlank(message = "Le telephone Promotion est obligatoire")
	private String telephone;
    @NotBlank(message = "Le code postal Promotion est obligatoire")
	private String code_Postal;

}
