package com.application.repositories;

import com.application.models.Enseignant;
import com.application.models.UniteEnseignement;
import com.application.models.UniteEnseignementPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniteEnseignementRepository extends JpaRepository<UniteEnseignement, UniteEnseignementPK> {

    List<UniteEnseignement> findUniteEnseignementByEnseignant(Enseignant enseignant);
    UniteEnseignement findUniteEnseignementsById(UniteEnseignementPK id);
}
