package com.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Enseignant")
public class Enseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int no_Enseignant;
	@NotBlank(message = "Le nom est obligatoire")
	private String nom;
	@NotBlank(message = "Le prénom est obligatoire")
	private String prenom;
	@NotBlank(message = "Le sexe est obligatoire")
	private String sexe;
	@NotBlank(message = "Le type est obligatoire")
	private String type;
	@NotBlank(message = "Le pays est obligatoire")
	private String pays;
	@NotBlank(message = "La ville est obligatoire")
	private String ville;
	@NotBlank(message = "L'adresse est obligatoire")
	private String adresse;	
	private String email_Perso;
	@NotBlank(message = "L'email UBO est obligatoire")
	private String email_Ubo;
	@NotBlank(message = "Le mobile est obligatoire")
	private String mobile;
	@NotBlank(message = "Le telephone est obligatoire")
	private String telephone;
	@NotBlank(message = "Le code postal est obligatoire")
	private String code_Postal;
	
	public Enseignant() {
		super();
	}
	
	public Enseignant(int no_Enseignant, String nom, String prenom, String sexe, String type, String pays,
			String ville, String adresse, String emailPerso, String emailUbo, String mobile, String telephone,
			String codePostal) {
		super();
		this.no_Enseignant = no_Enseignant;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.type = type;
		this.pays = pays;
		this.ville = ville;
		this.adresse = adresse;
		this.email_Perso = emailPerso;
		this.email_Ubo = emailUbo;
		this.mobile = mobile;
		this.telephone = telephone;
		this.code_Postal = codePostal;
	}

	public int getNoEnseignant() {
		return no_Enseignant;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getEmailPerso() {
		return email_Perso;
	}
	public void setEmailPerso(String emailPerso) {
		this.email_Perso = emailPerso;
	}
	public String getEmailUbo() {
		return email_Ubo;
	}
	public void setEmailUbo(String emailUbo) {
		this.email_Ubo = emailUbo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCodePostal() {
		return code_Postal;
	}
	public void setCodePostal(String codePostal) {
		this.code_Postal = codePostal;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		String nL = System.getProperty("line.separator");
		return "Enseignant num" + no_Enseignant + " - "+ nL +"\t\t"+ " Nom: "+ nL + nL +"\t\t" + nom
				+ prenom ;
	}

}
