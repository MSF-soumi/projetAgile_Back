package com.application.exceptions.ue;

import com.application.models.UniteEnseignementPK;
import org.springframework.util.StringUtils;

public class UENotFoundException extends RuntimeException{
    private static String generateMessage(String entity, UniteEnseignementPK id) {
        return "Aucune "+  StringUtils.capitalize(entity) + " n'existe pour l'identifiant : " + id + '.';
    }

    public UENotFoundException(Class c, UniteEnseignementPK id) {
        super(UENotFoundException.generateMessage(c.getSimpleName(), id));
    }
}
