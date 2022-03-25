package com.application.services;

import com.application.models.Enseignant;
import com.application.models.UniteEnseignement;
import com.application.models.UniteEnseignementPK;
import com.application.models.*;

import java.util.List;

public interface UniteEnseignementService {

    public List<UniteEnseignement> getAll();

    public UniteEnseignement getById(UniteEnseignementPK id);

    public List<UniteEnseignement> getUEByEnseignant(Long noEnseignant);

//    public double getSumEtd(Long noEnseignant);

    UniteEnseignement updateEnseignantUE(UniteEnseignementPK id, Enseignant enseignant);

    public Double getCurrentEtdSum(UniteEnseignementPK ue_pk, Long id);

    public UniteEnseignement updateUE(UniteEnseignement UE);

    public Double getEtdPerEnseignantType(Long id, int nbh_cm, int nbh_td, int nbh_tp);
    public List<UniteEnseignement> findByPromo(String code_Formation);

    //public UniteEnseignement updateEnseignantUE(UniteEnseignementPK id, Enseignant enseignant);
}
