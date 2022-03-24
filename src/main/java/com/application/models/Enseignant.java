package com.application.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Enseignant")
public class Enseignant implements Comparable<Enseignant>, Serializable {
	@Id
    @SequenceGenerator(name = "gen", sequenceName = "ENS_SEQ",schema="DOSI", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
	private Long no_Enseignant;
	private String nom;
	private String prenom;
	private String sexe;
	@ManyToOne
    @JoinColumn(name="type")
	private TypeEnseignant type;
	private String pays;
	private String ville;
	private String adresse;	
	private String email_Perso;
	private String email_Ubo;
	private String mobile;
	private String telephone;
	private String code_Postal;
	@OneToMany(mappedBy = "enseignant")
	private Set<UniteEnseignement> uniteEnseignementSet = new HashSet<>();
	@Transient
	private Integer nbh_cm;
	@Transient
	private Integer nbh_td;
	@Transient
	private Integer nbh_tp;
	@Transient
	private Double nbh_etd;

	@Override
	public int compareTo(Enseignant o) {
		if(this.nom.equals(o.nom)) {
			return this.prenom.compareTo(o.prenom);
		}
		else {
			return this.nom.compareTo(o.nom);
		}
	}

	public Enseignant(Long no_Enseignant, String nom, String prenom, String sexe, TypeEnseignant type, String pays, String ville, String adresse, String email_Perso, String email_Ubo, String mobile, String telephone, String code_Postal) {
		this.no_Enseignant = no_Enseignant;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.type = type;
		this.pays = pays;
		this.ville = ville;
		this.adresse = adresse;
		this.email_Perso = email_Perso;
		this.email_Ubo = email_Ubo;
		this.mobile = mobile;
		this.telephone = telephone;
		this.code_Postal = code_Postal;
	}
}
