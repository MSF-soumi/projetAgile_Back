package com.application.exceptions.ue;


public class ExceedETDException extends RuntimeException{
    private static String generateMessage(String entity, String id) {
        return "Vous ne pouvez pas enregistrer vos modifications, le nombre d'heures ETD de cette unité d'enseignement dépasse la valeur ETD de l'enseignant responsable.";
    }

    public ExceedETDException(Class c, String id) {
        super(ExceedETDException.generateMessage(c.getSimpleName(), id));
    }
}
