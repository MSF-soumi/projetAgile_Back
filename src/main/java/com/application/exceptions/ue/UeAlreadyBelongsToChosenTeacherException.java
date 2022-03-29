package com.application.exceptions.ue;

public class UeAlreadyBelongsToChosenTeacherException extends RuntimeException{
    private static String generateMessage(String entity, String id) {
        return "Cette unité d'enseignement appartient déjà à l'enseignant choisi.";
    }

    public UeAlreadyBelongsToChosenTeacherException(Class c, String id) {
        super(UeAlreadyBelongsToChosenTeacherException.generateMessage(c.getSimpleName(), id));
    }

}
