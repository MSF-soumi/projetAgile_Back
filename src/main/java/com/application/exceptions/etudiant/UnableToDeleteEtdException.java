package com.application.exceptions.etudiant;

public class UnableToDeleteEtdException extends RuntimeException{
    private static String generateMessage(String entity,Long id){
        return "l'étudiant ne peut pas être supprimé car il est déjà lié à des évaluations";
    }
    public UnableToDeleteEtdException(Class T,Long id){
        super(UnableToDeleteEtdException.generateMessage(T.getSimpleName(),id));
    }
}
