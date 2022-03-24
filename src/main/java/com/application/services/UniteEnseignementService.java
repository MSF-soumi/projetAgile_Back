package com.application.services;

import com.application.models.Enseignant;
import com.application.models.UniteEnseignement;
import com.application.models.UniteEnseignementPK;

import java.util.List;

public interface UniteEnseignementService {

    public List<UniteEnseignement> getAll();

    public List<UniteEnseignement> getUEByEnseignant(Long noEnseignant);

    public UniteEnseignement getById(UniteEnseignementPK id);
    
    public double getSumEtd(Long noEnseignant);

    UniteEnseignement updateEnseignantUE(UniteEnseignementPK id, Enseignant enseignant);

    public Double getCurrentEtdSum(UniteEnseignementPK ue_pk, Long id);

    public UniteEnseignement updateUE(UniteEnseignement UE);
}
