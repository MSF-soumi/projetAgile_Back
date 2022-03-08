package com.application.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Promotion")
public class Promotion {
	
	@JsonIgnore
	@EmbeddedId
	private PromotionPK id;
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant Enseignant;
	@NotBlank(message = "Le sigle Promotion est obligatoire")
	private String sigle_Promotion;
	@NotBlank(message = "Le nombre max des etudiants est obligatoire")
	private int nb_Max_Etudiant;
	@NotBlank(message = "La date de reponse de la liste principale est obligatoire")
	private String date_Reponse_Lp;
	@NotBlank(message = "La date de reponse de la liste d'attente est obligatoire")
	private String date_Reponse_Lalp;
	@NotBlank(message = "La date de rentrée est obligatoire")
	private String date_Rentree;
	@NotBlank(message = "Le lieu de rentrée est obligatoire")
	private String lieu_Rentree;
	private String processus_Stage;	
	private String commentaire;
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Promotion(Enseignant Enseignant, @NotBlank(message = "Le code formation est obligatoire") String code_Formation,
			@NotBlank(message = "L'annee universitaire est obligatoire") String annee_Universitaire,
			@NotBlank(message = "Le sigle Promotion est obligatoire") String sigle_Promotion,
			@NotBlank(message = "Le nombre max des etudiants est obligatoire") int nb_Max_Etudiant,
			@NotBlank(message = "La date de reponse de la liste principale est obligatoire") String date_Reponse_Lp,
			@NotBlank(message = "La date de reponse de la liste d'attente est obligatoire") String date_Reponse_Lalp,
			@NotBlank(message = "La date de rentrée est obligatoire") String date_Rentree,
			@NotBlank(message = "Le lieu de rentrée est obligatoire") String lieu_Rentree, String processus_Stage,
			String commentaire) {
		super();
		this.Enseignant = Enseignant;
		this.sigle_Promotion = sigle_Promotion;
		this.nb_Max_Etudiant = nb_Max_Etudiant;
		this.date_Reponse_Lp = date_Reponse_Lp;
		this.date_Reponse_Lalp = date_Reponse_Lalp;
		this.date_Rentree = date_Rentree;
		this.lieu_Rentree = lieu_Rentree;
		this.processus_Stage = processus_Stage;
		this.commentaire = commentaire;
	}
	public Enseignant getEnseignant() {
		return Enseignant;
	}
	public void setEnseignant(Enseignant Enseignant) {
		this.Enseignant = Enseignant;
	}

	public String getSigle_Promotion() {
		return sigle_Promotion;
	}
	public void setSigle_Promotion(String sigle_Promotion) {
		this.sigle_Promotion = sigle_Promotion;
	}
	public int getNb_Max_Etudiant() {
		return nb_Max_Etudiant;
	}
	public void setNb_Max_Etudiant(int nb_Max_Etudiant) {
		this.nb_Max_Etudiant = nb_Max_Etudiant;
	}
	public String getDate_Reponse_Lp() {
		return date_Reponse_Lp;
	}
	public void setDate_Reponse_Lp(String date_Reponse_Lp) {
		this.date_Reponse_Lp = date_Reponse_Lp;
	}
	public String getDate_Reponse_Lalp() {
		return date_Reponse_Lalp;
	}
	public void setDate_Reponse_Lalp(String date_Reponse_Lalp) {
		this.date_Reponse_Lalp = date_Reponse_Lalp;
	}
	public String getDate_Rentree() {
		return date_Rentree;
	}
	public void setDate_Rentree(String date_Rentree) {
		this.date_Rentree = date_Rentree;
	}
	public String getLieu_Rentree() {
		return lieu_Rentree;
	}
	public void setLieu_Rentree(String lieu_Rentree) {
		this.lieu_Rentree = lieu_Rentree;
	}
	public String getProcessus_Stage() {
		return processus_Stage;
	}
	public void setProcessus_Stage(String processus_Stage) {
		this.processus_Stage = processus_Stage;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		String nL = System.getProperty("line.separator");
		return "Promotion: " + sigle_Promotion + " - "+ nL +"\t\t Enseignant responsable: "+ " Nom: "+ nL + nL +"\t\t" + Enseignant.getNom()
				+ Enseignant.getPrenom()+nL +"Formation: "+ id.getCode_Formation();
	}

}
