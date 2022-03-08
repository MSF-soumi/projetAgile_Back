package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.models.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Integer>{

}
