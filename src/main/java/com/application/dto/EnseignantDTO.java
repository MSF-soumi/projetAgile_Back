package com.application.dto;

import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.application.models.TypeEnseignant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class EnseignantDTO {

	private Long no_Enseignant;
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Ce champs doit être une chaine de caractères.")
	private String nom;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Ce champs doit être une chaine de caractères.")
	private String prenom;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]", message = "Ce champs doit être une chaine de caractères.")
	private String sexe;
    
    @Valid
	private TypeEnseignantDTO type;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Ce champs doit être une chaine de caractères.")
	private String pays;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "[a-zA-Z]*", message = "Ce champs doit être une chaine de caractères")
	private String ville;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Pattern(regexp = "^.*[a-zA-Z0-9]+.*$", message = "Ce champs doit être une chaine de caractères.")
	private String adresse;
    
    @Email(message="Le format de l'email ne correspond pas au bon format, veuillez suivre le format \"abcd@gmail.com\".")
    private String email_Perso;
    
    @NotBlank(message = "Ce champs est oligatoire.")
    @Email(message="Le format de l'email ne correspond pas au bon format, l'adresse mail doit se terminer par \'@univ-brest.fr\'.")
    @Pattern(regexp= "^[\\w-\\.]+@(univ-brest+\\.)+fr", message="Le format de l'email ne correspond pas au bon format, l'adresse mail doit se terminer par \'@univ-brest.fr\'.")
    private String email_Ubo;
    
    @NotBlank(message = "Ce champs est oligatoire.")
	private String mobile;
    

	@NotBlank(message = "Ce champs est oligatoire.")
	private String telephone;
	
    @NotBlank(message = "Ce champs est oligatoire.")
	@Size(min = 1, max = 10)
	private String code_Postal;

    private Set<UniteEnseignementDTO> uniteEnseignementSet = new HashSet<>();

    private Integer nbh_Cm;

    private Integer nbh_Td;

    private Integer nbh_Tp;

    private Double nbh_Etd;

}
