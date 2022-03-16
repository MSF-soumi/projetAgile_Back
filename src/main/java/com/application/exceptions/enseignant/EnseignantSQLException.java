package com.application.exceptions.enseignant;

import org.springframework.util.StringUtils;

public class EnseignantSQLException extends RuntimeException {
	
	private static String generateMessage(String entity, Long id) {	
		return "l'enseignant ayant l'id : " + id +  " ne pourra pas etre supprimé, car il a des relations dans d'autres tables! --" + StringUtils.capitalize(entity);
	}
	
	public EnseignantSQLException(Class c, Long id) {
		super(EnseignantSQLException.generateMessage(c.getSimpleName(), id));
	}
}