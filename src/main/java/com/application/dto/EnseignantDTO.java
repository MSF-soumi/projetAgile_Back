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
	private Sexe sexe;
    @NotBlank(message = "Le type enseignant est obligatoire")
	private TypeEnseignant type;
    @NotBlank(message = "Le pays enseignant est obligatoire")
	private Pays pays;
    @NotBlank(message = "Le ville enseignant est obligatoire")
	private String ville;
    @NotBlank(message = "L'adresse enseignant est obligatoire")
	private String adresse;
    @Email
	private String email_Perso;
	@Email
    @NotBlank(message = "L'email UBO enseignant est obligatoire")
	private String email_Ubo;
	@Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
					+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
					+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$", message = "mobile invalide")
    @NotBlank(message = "Le mobile enseignant est obligatoire")
	private String mobile;

	@Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$", message = "mobile invalide")
    @NotBlank(message = "Le telephone enseignant est obligatoire")
	private String telephone;

	@Size(min = 5, max = 5)
	@Pattern(regexp = "[0-9]+")
    @NotBlank(message = "Le code postal enseignant est obligatoire")
	private String code_Postal;

}
