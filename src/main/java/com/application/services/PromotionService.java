package com.application.services;

<<<<<<< Updated upstream
import com.application.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PromotionService {
    @Autowired
    private final PromotionRepository promotionRepository;
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

=======
public interface PromotionService {
>>>>>>> Stashed changes

	
}
