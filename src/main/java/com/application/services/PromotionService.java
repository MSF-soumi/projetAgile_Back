package com.application.services;

import com.application.models.Promotion;
import com.application.models.PromotionPK;

import java.util.List;
import java.util.Map;

public interface PromotionService {
    //public Promotion create(Promotion promotion);

    public List<Promotion> getAll();

    public List<Promotion> updateWorkflow(List<Promotion> promotions);

    //public Promotion getById(Long id);

    //public Promotion update(Promotion promotion);

    //public void delete(Long id);
}
