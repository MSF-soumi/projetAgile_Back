package com.application.services.Impl;

import com.application.models.Promotion;
import com.application.models.PromotionPK;
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
    public List<Promotion> getAll(){
        return promotionRepository.findAll();
    }

    @Override
    public List<Promotion> updateWorkflow(List<Promotion> promotions){
        for(Promotion promotion: promotions){
            var oldPromotion = promotionRepository.getById(promotion.getId());
            oldPromotion.setProcessus_Stage(promotion.getProcessus_Stage());
            promotionRepository.save(promotion);
        }
        return promotionRepository.findAll();
    }
}
