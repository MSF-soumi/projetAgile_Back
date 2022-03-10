package com.application.models;

import lombok.*;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Embeddable
public class PromotionPK implements Serializable{
	private static final long serialVersionUID = 1L;

	private String code_Formation;
	private String annee_Universitaire;
}
