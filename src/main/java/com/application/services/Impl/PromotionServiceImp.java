package com.application.services.Impl;

import com.application.models.Promotion;
import com.application.models.PromotionPK;
import com.application.repositories.PromotionRepository;
import com.application.services.PromotionService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

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
	@Override
	public Promotion getById(PromotionPK id)
	{
		Optional<Promotion> res=promotionRepository.findById(id);
		return res.isPresent()?res.get():null;
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

	@Override
	public boolean delete(PromotionPK id) {
		try{
			promotionRepository.deleteById(id);
			System.out.println("delete passed ");
			return true;
		}catch (Exception e){
			System.out.println("Exception "+e.getMessage());
			return false;
		}
		
	}
}
