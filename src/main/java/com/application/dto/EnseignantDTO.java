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
    @Pattern(regexp = "[a-zA-Z]*", message = "Le nom doit être une chaine de caractères et ne peut pas contenir des cacatères numériques ou des caractères spéciaux.")
	private String nom;
    
    @NotBlank(message = "Le prenom de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le prénom doit être une chaine de caractères et ne peut pas contenir des cacatères numériques ou des caractères spéciaux.")
	private String prenom;
    
    @NotBlank(message = "Le sexe de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]", message = "Le sexe doit être une chaine de caractères et ne peut pas contenir des cacatères numériques ou des caractères spéciaux.")
	private String sexe;
    
    @NotBlank(message = "Le type de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le Type de l'enseignant doit être une chaine de caractères et ne peut pas contenir des cacatères numériques ou des caractères spéciaux.")
	private String type;
    
    @NotBlank(message = "Le pays de l'enseignant doit être renseigné.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le pays doit être une chaine de caractères et ne peut pas contenir des cacatères numériques ou des caractères spéciaux.")
	private String pays;
    
    @NotBlank(message = "Le ville de l'enseignant doit être renseignée")
    @Pattern(regexp = "[a-zA-Z]*", message = "La ville doit être une chaine de caractères et ne peut pas contenir des cacatères numériques ou des caractères spéciaux.")
	private String ville;
    
    @NotBlank(message = "L'adresse de l'enseignant doit être renseignée.")
    @Pattern(regexp = "[a-zA-Z]*", message = "L'adresse doit être une chaine de caractères alphanumériques et ne peut pas contenir des caractères spéciaux.")
	private String adresse;
    

    @Email(message="Format d'email not respectée, merci de suivre l'exemple abcd@gmail.com")
    private String email_Perso;
   
    
    @NotBlank(message = "L'email UBO de l'enseignant doit être renseigné.")
    @Email(message="Le format de l'email ne correspond pas au bon format, merci de suivre le format \"nomprenom@univ-brest.fr\".")
    @Pattern(regexp= "^[\\w-\\.]+@(univ-brest+\\.)+fr", message="Le format de l'email ne correspond pas au bon format, veuillez suivre le format \"nomprenom@univ-brest.fr\".")
    private String email_Ubo;
    
    @NotBlank(message = "Le numéro de téléphone mobile de l'enseignant doit être renseigné.")
	@Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Le format du numéro de téléphone mobile ne correspond pas au bon format, veuillez suivre le format : \"+33685749132\".")
	private String mobile;
    
	@NotBlank(message = "Le numéro de téléphone de l'enseignant doit être renseigné.")
	@Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Le format du numéro de téléphone ne correspond pas au bon format, veuillez suivre le format : \"+33685749132\".")

	private String telephone;
	
    @NotBlank(message = "Le code postal de l'enseignant doit être renseigné.")
	@Size(min = 5, max = 5)
	@Pattern(regexp = "[0-9]+")
	private String code_Postal;

}
