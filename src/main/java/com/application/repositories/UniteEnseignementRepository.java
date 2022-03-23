package com.application.repositories;

import com.application.models.Enseignant;
import com.application.models.UniteEnseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniteEnseignementRepository extends JpaRepository<UniteEnseignement, String> {

    List<UniteEnseignement> findUniteEnseignementByEnseignant(Enseignant enseignant);
}
