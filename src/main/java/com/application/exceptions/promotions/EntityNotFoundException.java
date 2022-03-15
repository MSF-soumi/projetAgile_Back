package com.application.exceptions.promotions;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Class c, String typeParametre, String parameter) {
        super(EntityNotFoundException.generateMessage(c.getSimpleName(), typeParametre, parameter));
    }

    private static String generateMessage(String entity, String typeParametre, String valeurParametre) {
        return "Aucun(e) " + StringUtils.capitalize(entity) +
                " trouvé(e) avec " +
                typeParametre + " = " +
                valeurParametre;
    }
}
