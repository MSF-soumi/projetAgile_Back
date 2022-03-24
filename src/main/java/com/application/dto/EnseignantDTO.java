package com.application.dto;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class EnseignantDTO {

	private Long no_Enseignant;
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le nom doit être une chaine de caractères.")
	private String nom;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le prénom doit être une chaine de caractères.")
	private String prenom;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]", message = "Le sexe doit être une chaine de caractères.")
	private String sexe;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le Type doit être une chaine de caractères.")
	private String type;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Le pays doit être une chaine de caractères.")
	private String pays;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "La ville doit être une chaine de caractères")
	private String ville;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "^.*[a-zA-Z0-9]+.*$", message = "L'adresse doit être une chaine de caractères.")
	private String adresse;
    
    @Email(message="Le format de l'email ne correspond pas au bon format, veuillez suivre le format \"abcd@gmail.com\".")
    private String email_Perso;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Email(message="Le format de l'email ne correspond pas au bon format, merci de suivre le format \"nomprenom@univ-brest.fr\".")
    @Pattern(regexp= "^[\\w-\\.]+@(univ-brest+\\.)+fr", message="Le format de l'email ne correspond pas au bon format, veuillez suivre le format \"nomprenom@univ-brest.fr\".")
    private String email_Ubo;
    
    @NotBlank(message = "Ce champs est oligatoire.")
	private String mobile;
    

	@NotBlank(message = "Ce champs est oligatoire.")
	private String telephone;
	
    @NotBlank(message = "Ce champs est oligatoire.")
	@Size(min = 1, max = 10)
	private String code_Postal;

//    private Set<UniteEnseignementDTO> uniteEnseignementSet = new HashSet<>();
//
//    private Integer nbh_cm;
//
//    private Integer nbh_td;
//
//    private Integer nbh_tp;
//
//    private Double nbh_etd;

}
