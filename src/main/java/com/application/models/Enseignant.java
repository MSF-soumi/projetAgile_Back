package com.application.models;

import javax.persistence.*;

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
	private String type;
	private String pays;
	private String ville;
	private String adresse;	
	private String email_Perso;
	private String email_Ubo;
	private String mobile;
	private String telephone;
	private String code_Postal;
//	@OneToMany(mappedBy = "enseignant")
//	private Set<UniteEnseignement> uniteEnseignementSet = new HashSet<>();
//	@Transient
//	private Integer nbh_cm;
//	@Transient
//	private Integer nbh_td;
//	@Transient
//	private Integer nbh_tp;
//	@Transient
//	private Double nbh_etd;

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
