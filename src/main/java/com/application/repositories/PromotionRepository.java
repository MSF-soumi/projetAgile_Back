package com.application.repositories;

import com.application.models.PromotionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.models.Promotion;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, PromotionPK>{

    @Query(value = "select * from promotion where sigle_Promotion = ?1", nativeQuery=true)
    List<Promotion> findBySiglePromotion(String siglePromotion);
}
