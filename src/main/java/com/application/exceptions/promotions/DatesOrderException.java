package com.application.exceptions.promotions;

import org.springframework.util.StringUtils;

public class DatesOrderException extends RuntimeException {

    public DatesOrderException(Class c) {
        super(DatesOrderException.generateMessage(c.getSimpleName()));
    }

    private static String generateMessage(String entity) {
        return "Les dates de " + StringUtils.capitalize(entity) +
                " doivent respecter l'ordre :  Date de réponse Liste Principale < "+
                "Date de réponse Liste d'attente < Date de rentrée ";
    }
}
