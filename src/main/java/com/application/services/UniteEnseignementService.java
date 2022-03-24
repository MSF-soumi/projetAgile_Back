package com.application.services;

import com.application.models.*;

import java.util.List;

public interface UniteEnseignementService {

    public List<UniteEnseignement> getAll();

    public UniteEnseignement getById(UniteEnseignementPK id);

    public List<UniteEnseignement> getUEByEnseignant(Long noEnseignant);
    
    public double getSumEtd(Long noEnseignant);

    public Double getCurrentEtdSum(UniteEnseignementPK ue_pk, Long id);

    public UniteEnseignement updateUE(UniteEnseignement UE);

    //public UniteEnseignement updateEnseignantUE(UniteEnseignementPK id, Enseignant enseignant);
}
