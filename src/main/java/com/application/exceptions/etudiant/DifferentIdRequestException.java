package com.application.exceptions.etudiant;


import org.springframework.util.StringUtils;

public class DifferentIdRequestException extends RuntimeException{
	private static String generateMessage(String entity, String id) {

		return "L'identifiant saisi comme paramètre ne correspond pas aux données de l' " + StringUtils.capitalize(entity) + " saisi." +
				"Veuillez vérifier et réessayer.";
		
	}
	
	public DifferentIdRequestException(Class c, String id) {
		super(DifferentIdRequestException.generateMessage(c.getSimpleName(), id));
	}

}
