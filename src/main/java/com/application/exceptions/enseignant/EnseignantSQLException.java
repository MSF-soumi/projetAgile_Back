package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EnseignantSQLException extends RuntimeException {
	
	private static String generateMessage(String entity, Long id) {	

		return "L'enseignant ne peut pas être supprimé car il est responsable d'une promotion.";
	}

	
	public EnseignantSQLException(Class c, Long id) {
		super(EnseignantSQLException.generateMessage(c.getSimpleName(), id));
	}

}

