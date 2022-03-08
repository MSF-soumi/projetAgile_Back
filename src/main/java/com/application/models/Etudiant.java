package com.application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Etudiant")
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private String no_Etudiant;
	private String code_Formation;
	private String annee_Universitaire;
	private String universite_Origine;
	private int groupe_Tp;
	private int groupe_Anglais;
	private String date_Naissance;
	private String lieu_Naissance;
	private String natioalite;
	private String nom;
	private String prenom;
	private String sexe;
	private String type;
	private String pays_Origine;
	private String ville;
	private String adresse;	
	private String email;
	private String email_Ubo;
	private String mobile;
	private String telephone;
	private String code_Postal;
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String no_Etudiant, String code_Formation, String annee_Universitaire, String universite_Origine,
			int groupe_Tp, int groupe_Anglais, String date_Naissance, String lieu_Naissance, String natioalite,
			String nom, String prenom, String sexe, String type, String pays_Origine, String ville, String adresse,
			String email, String email_Ubo, String mobile, String telephone, String code_Postal) {
		super();
		this.no_Etudiant = no_Etudiant;
		this.code_Formation = code_Formation;
		this.annee_Universitaire = annee_Universitaire;
		this.universite_Origine = universite_Origine;
		this.groupe_Tp = groupe_Tp;
		this.groupe_Anglais = groupe_Anglais;
		this.date_Naissance = date_Naissance;
		this.lieu_Naissance = lieu_Naissance;
		this.natioalite = natioalite;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.type = type;
		this.pays_Origine = pays_Origine;
		this.ville = ville;
		this.adresse = adresse;
		this.email = email;
		this.email_Ubo = email_Ubo;
		this.mobile = mobile;
		this.telephone = telephone;
		this.code_Postal = code_Postal;
	}

	public String getNo_Etudiant() {
		return no_Etudiant;
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

	public String getUniversite_Origine() {
		return universite_Origine;
	}

	public void setUniversite_Origine(String universite_Origine) {
		this.universite_Origine = universite_Origine;
	}

	public int getGroupe_Tp() {
		return groupe_Tp;
	}

	public void setGroupe_Tp(int groupe_Tp) {
		this.groupe_Tp = groupe_Tp;
	}

	public int getGroupe_Anglais() {
		return groupe_Anglais;
	}

	public void setGroupe_Anglais(int groupe_Anglais) {
		this.groupe_Anglais = groupe_Anglais;
	}

	public String getDate_Naissance() {
		return date_Naissance;
	}

	public void setDate_Naissance(String date_Naissance) {
		this.date_Naissance = date_Naissance;
	}

	public String getLieu_Naissance() {
		return lieu_Naissance;
	}

	public void setLieu_Naissance(String lieu_Naissance) {
		this.lieu_Naissance = lieu_Naissance;
	}

	public String getNatioalite() {
		return natioalite;
	}

	public void setNatioalite(String natioalite) {
		this.natioalite = natioalite;
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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPays_Origine() {
		return pays_Origine;
	}

	public void setPays_Origine(String pays_Origine) {
		this.pays_Origine = pays_Origine;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_Ubo() {
		return email_Ubo;
	}

	public void setEmail_Ubo(String email_Ubo) {
		this.email_Ubo = email_Ubo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCode_Postal() {
		return code_Postal;
	}

	public void setCode_Postal(String code_Postal) {
		this.code_Postal = code_Postal;
	}
	
	@Override
	public String toString() {
		String nL = System.getProperty("line.separator");
		return "Etudiant num" + this.no_Etudiant + " - "+ nL +"\t\t"+ " Nom: "+ nL + nL +"\t\t" + nom
				+ prenom ;
	}
	
}
