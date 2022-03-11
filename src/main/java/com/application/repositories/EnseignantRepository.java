package com.application.repositories;

import com.application.models.PromotionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.models.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
	
	@Query(value = "select * from enseignant where email_Ubo = ?1", nativeQuery=true)
		Enseignant findByEmail_Ubo(String email_Ubo);
}
