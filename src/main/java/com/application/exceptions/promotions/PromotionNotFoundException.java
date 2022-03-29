package com.application.exceptions.promotions;
import org.springframework.util.StringUtils;

import com.application.models.PromotionPK;

public class PromotionNotFoundException extends RuntimeException{


	private static String generateMessage(String entity, PromotionPK id) {
		return "Aucune "+  StringUtils.capitalize(entity) + " n'existe pour cet identifiant. ";
	}
	
	public PromotionNotFoundException(Class c, PromotionPK id) {
		super(PromotionNotFoundException.generateMessage(c.getSimpleName(), id));
	}

}
