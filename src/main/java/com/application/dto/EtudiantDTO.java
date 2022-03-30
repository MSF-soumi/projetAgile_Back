package com.application.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EtudiantDTO {
	
	private String no_Etudiant;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	private String code_Formation;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	@Pattern(regexp = "[0-9]{4}-[0-9]{4}", message = "L'année universitaire doit respecter le fromat YYYY-YYYY.")
	private String annee_Universitaire;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	private String nom;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	private String prenom;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	@Pattern(regexp = "[a-zA-Z]", message = "Ce champs doit être une chaine de caractères.")
	private String sexe;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @NotNull(message = "Ce champs est obligatoire.")
	private LocalDate date_Naissance;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	private String lieu_Naissance;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	private String nationalite;
	
	private String telephone;
	
	private String mobile;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	@Email(message="Le format de l'email ne correspond pas au bon format, veuillez suivre le format \"abcd@gmail.com\".")
	private String email;
	
	@Email
	private String email_Ubo;
	
	@NotBlank(message = "Ce champs est oligatoire.")
	private String adresse;
	
    @NotBlank(message = "Ce champs est oligatoire.")
	@Size(min = 1, max = 10)
	private String code_Postal;
    
    @NotBlank(message = "Ce champs est oligatoire.")
	private String ville;
	
    @NotBlank(message = "Ce champs est oligatoire.")
	private String pays_Origine;
	
    @NotBlank(message = "Ce champs est oligatoire.")
	private String universite_origine;
	
	private Long groupe_Tp;
	
	private Long groupe_Anglais;
}
