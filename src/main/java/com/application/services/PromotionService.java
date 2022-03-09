package com.application.services;

import com.application.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PromotionService {
    @Autowired
    private final PromotionRepository promotionRepository;
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

}
