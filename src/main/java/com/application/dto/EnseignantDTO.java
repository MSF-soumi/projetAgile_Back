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
    @NotBlank(message = "Le nom de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le nom doit être une chaine de caractères.")
	private String nom;
    
    @NotBlank(message = "Le prenom de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le prénom doit être une chaine de caractères.")
	private String prenom;
    
    @NotBlank(message = "Le sexe de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]", message = "Le sexe doit être une chaine de caractères.")
	private String sexe;
    
    @NotBlank(message = "Le type de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le Type doit être une chaine de caractères.")
	private String type;
    
    @NotBlank(message = "Le pays de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le pays doit être une chaine de caractères.")
	private String pays;
    
    @NotBlank(message = "Le ville de l'enseignant doit être renseignée")
    @Pattern(regexp = "[a-zA-Z]*", message = "La ville doit être une chaine de caractères")
	private String ville;
    
    @NotBlank(message = "L'adresse de l'enseignant doit être renseignée.")
    @Pattern(regexp = "^.*[a-zA-Z0-9]+.*$", message = "L'adresse doit être une chaine de caractères.")
	private String adresse;
    
    @Email(message="Le format de l'email ne correspond pas au bon format, veuillez suivre le format \"abcd@gmail.com\".")
    private String email_Perso;
    
    @NotBlank(message = "L'email UBO de l'enseignant doit être renseigné.")
    @Email(message="Le format de l'email ne correspond pas au bon format, merci de suivre le format \"nomprenom@univ-brest.fr\".")
    @Pattern(regexp= "^[\\w-\\.]+@(univ-brest+\\.)+fr", message="Le format de l'email ne correspond pas au bon format, veuillez suivre le format \"nomprenom@univ-brest.fr\".")
    private String email_Ubo;
    
    @NotBlank(message = "Le mobile enseignant est obligatoire")
	private String mobile;
    
	@NotBlank(message = "Le telephone enseignant est obligatoire")
	private String telephone;
	
    @NotBlank(message = "Le code postal de l'enseignant doit être renseigné.")
	
    @NotBlank(message = "Le nom de l'enseignant est obligatoire")
	private String nom;
    
    @NotBlank(message = "Le prénom de l'enseignant est obligatoire")
	private String prenom;
    
    @NotBlank(message = "Le sexe de l'enseignant est obligatoire")
	private String sexe;
    
    @NotBlank(message = "Le type de l'enseignant est obligatoire")
	private String type;
    
    @NotBlank(message = "Le pays de l'enseignant est obligatoire")
	private String pays;
    
    @NotBlank(message = "La ville de l'enseignant est obligatoire")
	private String ville;
    
    @NotBlank(message = "L'adresse de l'enseignant est obligatoire")
	private String adresse;
    
    @Email(message="Format d'email not respecté, merci de suivre le format abcd@gmail.com")
	private String email_Perso;
    
    @NotBlank(message = "L'email UBO de l'enseignant est obligatoire")
    @Email(message="Format d'email not respecté, merci de suivre le format nomprenom@univ-brest.fr")
	private String email_Ubo;
    
    @NotBlank(message = "Le mobile de l'enseignant est obligatoire")
	@Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
					+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
					+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$", message = "Mobile invalide")
	private String mobile;
    
	@NotBlank(message = "Le télephone de l'enseignant est obligatoire")
	@Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$", message = "Téléphone invalide")
	private String telephone;

    @NotBlank(message = "Le code postal de l'enseignant est obligatoire")
	@Size(min = 5, max = 5)
	@Pattern(regexp = "[0-9]+")
	private String code_Postal;

}
