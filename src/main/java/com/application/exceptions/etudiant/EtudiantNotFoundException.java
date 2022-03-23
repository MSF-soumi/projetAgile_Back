package com.application.exceptions.etudiant;

import org.springframework.util.StringUtils;

public class EtudiantNotFoundException extends RuntimeException {

	private static String generateMessage(String entity, Long id) {
		return "Aucun étudiant n'existe pour l'identifiant : " + id + '.';
	}
	
	public EtudiantNotFoundException(Class c, Long id) {
		super(EtudiantNotFoundException.generateMessage(c.getSimpleName(), id));
	}

}
