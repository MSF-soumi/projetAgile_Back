package com.application.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class PromotionPK {
	
	@NotBlank(message = "Le code formation est obligatoire")
	private String code_Formation;
	@NotBlank(message = "L'annee universitaire est obligatoire")
	private String annee_Universitaire;
	
	public PromotionPK(@NotBlank(message = "Le code formation est obligatoire") String code_Formation,
			@NotBlank(message = "L'annee universitaire est obligatoire") String annee_Universitaire) {
		super();
		this.code_Formation = code_Formation;
		this.annee_Universitaire = annee_Universitaire;
	}

	public String getCode_Formation() {
		return code_Formation;
	}

	public void setCode_Formation(String code_Formation) {
		this.code_Formation = code_Formation;
	}

	public String getAnnee_Universitaire() {
		return annee_Universitaire;
	}

	public void setAnnee_Universitaire(String annee_Universitaire) {
		this.annee_Universitaire = annee_Universitaire;
	}
	
	
}
