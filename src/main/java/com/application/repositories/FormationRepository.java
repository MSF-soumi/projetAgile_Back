package com.application.repositories;

import com.application.models.Enseignant;
import com.application.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {

    @Query(value = "select * from formation where code_formation = ?1", nativeQuery=true)
    Formation findByCode_Formation(String codeFormation);
}
