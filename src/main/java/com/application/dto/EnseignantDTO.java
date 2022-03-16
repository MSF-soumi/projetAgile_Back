package com.application.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.application.models.Pays;
import com.application.models.Sexe;
import com.application.models.TypeEnseignant;

import lombok.Data;

@Data
public class EnseignantDTO {
	
	private Long no_Enseignant;
    @NotBlank(message = "Le nom enseignant est obligatoire")
	private String nom;
    
    @NotBlank(message = "Le prenom enseignant est obligatoire")
	private String prenom;
    
    @NotBlank(message = "Le sexe enseignant est obligatoire")
	private String sexe;
    
    @NotBlank(message = "Le type enseignant est obligatoire")
	private String type;
    
    @NotBlank(message = "Le pays enseignant est obligatoire")
	private String pays;
    
    @NotBlank(message = "Le ville enseignant est obligatoire")
	private String ville;
    
    @NotBlank(message = "L'adresse enseignant est obligatoire")
	private String adresse;
    
    @Email(message="Format d'email not respectée, merci de suivre l'exemple abcd@gmail.com")
    private String email_Perso;
    
    @NotBlank(message = "L'email UBO enseignant est obligatoire")
    @Email(message="Format d'email not respectée, merci de suivre l'exemple nomprenom@univ-brest.fr")
    @Pattern(regexp= "^[\\w-\\.]+@(univ-brest+\\.)+fr", message="Please provide a valid email address")
    private String email_Ubo;
    
    @NotBlank(message = "Le mobile enseignant est obligatoire")
	@Pattern(regexp = "((?:9[679]|8[035789]|6[789]|5[90]|42|3[578]|2[1-689])|9[0-58]|8[1246]|6[0-6]|5[1-8]|4[013-9]|3[0-469]|2[70]|7|1)(?:\\W*\\d){0,13}\\d$", message = "mobile invalide")
	private String mobile;
    
	@NotBlank(message = "Le telephone enseignant est obligatoire")
	@Pattern(regexp = "((?:9[679]|8[035789]|6[789]|5[90]|42|3[578]|2[1-689])|9[0-58]|8[1246]|6[0-6]|5[1-8]|4[013-9]|3[0-469]|2[70]|7|1)(?:\\W*\\d){0,13}\\d$", message = "mobile invalide")
	private String telephone;
	
    @NotBlank(message = "Le code postal enseignant est obligatoire")
	@Size(min = 5, max = 5)
	@Pattern(regexp = "[0-9]+")
	private String code_Postal;

}
