package com.application.models;

import lombok.*;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class PromotionPK implements Serializable{
	private String code_Formation;
	private String annee_Universitaire;
}
