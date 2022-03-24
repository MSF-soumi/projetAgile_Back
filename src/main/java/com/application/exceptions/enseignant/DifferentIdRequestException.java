package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class DifferentIdRequestException extends RuntimeException{
	private static String generateMessage(String entity, Long id) {

		return "L'identifiant saisi comme paramètre ne correspond pas aux données de l' " + StringUtils.capitalize(entity) + " saisi." +
				"Veuillez vérifier et réessayer.";
		
	}
	
	public DifferentIdRequestException(Class c, Long id) {
		super(DifferentIdRequestException.generateMessage(c.getSimpleName(), id));
	}

}
