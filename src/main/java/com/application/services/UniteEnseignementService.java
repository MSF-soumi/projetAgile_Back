package com.application.services;

import com.application.models.UniteEnseignement;

import java.util.List;

public interface UniteEnseignementService {

    public List<UniteEnseignement> getAll();

    public List<UniteEnseignement> getUEByEnseignant(Long noEnseignant);
    
    public double getSumEtd(Long noEnseignant);

    public UniteEnseignement updateUE(UniteEnseignement UE);
}
