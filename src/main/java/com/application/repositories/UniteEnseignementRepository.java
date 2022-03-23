package com.application.repositories;

import com.application.models.UniteEnseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteEnseignementRepository extends JpaRepository<UniteEnseignement, String> {
}
