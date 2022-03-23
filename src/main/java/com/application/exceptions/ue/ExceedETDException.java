package com.application.exceptions.ue;


public class ExceedETDException extends RuntimeException{
    private static String generateMessage(String entity, String id) {
        return "Vous ne pouvez pas enregistrer vos modifications, la valeur ETD de cette unité d'enseignement dépasse la valeur ETD de l'enseignant";
    }

    public ExceedETDException(Class c, String id) {
        super(ExceedETDException.generateMessage(c.getSimpleName(), id));
    }
}
