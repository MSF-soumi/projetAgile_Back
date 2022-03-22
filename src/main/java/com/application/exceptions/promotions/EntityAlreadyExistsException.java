package com.application.exceptions.promotions;

import org.springframework.util.StringUtils;

public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(Class c, String typeParametre, String parameter) {
        super(EntityAlreadyExistsException.generateMessage(c.getSimpleName(), typeParametre, parameter));
    }

    private static String generateMessage(String entity, String typeParametre, String valeurParametre) {
        return "Cette promotion existe déjà.";
    }
}
