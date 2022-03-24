package com.application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.io.Serializable;

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

	@Override
	public int compareTo(Enseignant o) {
		if(this.nom.equals(o.nom)) {
			return this.prenom.compareTo(o.prenom);
		}
		else {
			return this.nom.compareTo(o.nom);
		}
	}
}
