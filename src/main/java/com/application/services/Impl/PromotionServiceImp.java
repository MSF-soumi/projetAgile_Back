package com.application.services.Impl;

import com.application.models.Promotion;
import com.application.repositories.PromotionRepository;
import com.application.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImp implements PromotionService {
    @Autowired
    public final PromotionRepository promotionRepository;

    public PromotionServiceImp(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion create(Promotion promotion) {
        return this.promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> getAll(){
        return promotionRepository.findAll();
    }
}
