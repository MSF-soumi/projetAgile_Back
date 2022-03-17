package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class DifferentIdRequestException extends RuntimeException{
	private static String generateMessage(String entity, Long id) {
		return "Veuillez saisir la meme Identifiant entre pathVariable et l'entité " + StringUtils.capitalize(entity);
		
	}
	
	public DifferentIdRequestException(Class c, Long id) {
		super(DifferentIdRequestException.generateMessage(c.getSimpleName(), id));
	}
}
