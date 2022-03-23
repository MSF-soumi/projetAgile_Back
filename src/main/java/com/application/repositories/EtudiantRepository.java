package com.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.application.models.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,String>{
	
	@Query(value = "select * from etudiant where code_Formation = ?1 and annee_Universitaire = ?2", nativeQuery=true)
	List<Etudiant> findByPromo(String code_Formation,String annee_Universitaire);

    public boolean existsById(String id);
    
    @Query(value = "select * from etudiant where email_Ubo = ?1", nativeQuery=true)
	Etudiant findByEmail_Ubo(String email_Ubo);
}
