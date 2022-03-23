package com.application.exceptions.etudiant;

import org.springframework.util.StringUtils;

public class EtdNotFoundException extends RuntimeException{
    private static String generateMessage(String entity,Long id){
        return "Aucun "+ StringUtils.capitalize(entity) + " n'existe pour l'identifiant :"+ id + ".";
    }
    public EtdNotFoundException(Class T,Long id){
        super(EtdNotFoundException.generateMessage(T.getSimpleName(),id));
    }
}
