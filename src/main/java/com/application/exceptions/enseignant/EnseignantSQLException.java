package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EnseignantSQLException extends RuntimeException {
	
	private static String generateMessage(String entity, Long id) {	

		return "L'" + StringUtils.capitalize(entity) + " ayant l'identifiant : " + id +  " ne pourra pas être supprimé, car il a des relations avec d'autres tables.";
	}

	
	public EnseignantSQLException(Class c, Long id) {
		super(EnseignantSQLException.generateMessage(c.getSimpleName(), id));
	}

}

