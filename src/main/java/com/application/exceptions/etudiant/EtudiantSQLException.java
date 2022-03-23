package com.application.exceptions.etudiant;

import org.springframework.util.StringUtils;

public class EtudiantSQLException extends RuntimeException {

    private static String generateMessage(String entity, String id) {

        return "L'étudiant ne peut pas être supprimé car il a des évaluations.";
    }


    public EtudiantSQLException(Class c, String id) {
        super(EtudiantSQLException.generateMessage(c.getSimpleName(), id));
    }

}

