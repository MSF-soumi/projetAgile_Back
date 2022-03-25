package com.application.services.Impl;

import com.application.exceptions.EntityNotFoundException;
import com.application.exceptions.ue.ExceedETDException;
import com.application.models.Enseignant;
import com.application.models.UniteEnseignement;
import com.application.models.UniteEnseignementPK;
import com.application.repositories.EnseignantRepository;
import com.application.repositories.UniteEnseignementRepository;
import com.application.services.UniteEnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteEnseignementImp implements UniteEnseignementService {

    @Autowired
    private final UniteEnseignementRepository uniteEnseignementRepository;
    public final EnseignantRepository enseignantRepository;
    @Autowired
    public final EnseignantServiceImp enseignantService;

    public UniteEnseignementImp(UniteEnseignementRepository uniteEnseignementRepository, EnseignantRepository enseignantRepository, EnseignantServiceImp enseignantService) {
        this.uniteEnseignementRepository = uniteEnseignementRepository;
        this.enseignantRepository = enseignantRepository;
        this.enseignantService = enseignantService;
    }

    @Override
    public List<UniteEnseignement> getAll() {
        return uniteEnseignementRepository.findAll();
    }

    @Override
    public List<UniteEnseignement> getUEByEnseignant(Long noEnseignant) {
        if (enseignantExists(noEnseignant))
        return uniteEnseignementRepository.findUniteEnseignementByEnseignant(enseignantRepository.getById(noEnseignant));
        else throw new EntityNotFoundException(Enseignant.class, "Numéro Enseignant", noEnseignant.toString());
    }

    @Override
    public UniteEnseignement getById(UniteEnseignementPK id) {
        return uniteEnseignementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(UniteEnseignement.class));
    }

    @Override
    public UniteEnseignement updateUE(UniteEnseignement UE) {
        //double nbh_etd=UE.getNbh_etd();
        Long id=UE.getEnseignant().getNo_Enseignant();
        List<UniteEnseignement> UEens_list=getUEByEnseignant(id);

        double nbh_etd_ens=0;
        for(int i=0;i<UEens_list.size();i++){
           nbh_etd_ens+= UEens_list.get(i).getNbhEtd();
        }
        nbh_etd_ens+=getDiffupdatedUE(UE);

        if(nbh_etd_ens <= 192)
            return uniteEnseignementRepository.save(UE);
        else throw new ExceedETDException(UniteEnseignement.class,id.toString());
    }

    public double getDiffupdatedUE(UniteEnseignement UE){
        double new_etd=UE.getNbh_etd();
        UniteEnseignement old_UE=uniteEnseignementRepository.findUniteEnseignementsById(UE.getId());
        double old_etd=old_UE.getNbh_etd();
        double diff=new_etd-old_etd;
        return diff;

    }

    @Override
    public UniteEnseignement updateEnseignantUE(UniteEnseignementPK ue_pk, Enseignant newEnseignant){
        var uniteEnseignement = uniteEnseignementRepository.getById(ue_pk);
        var currentEnseignant = uniteEnseignementRepository.getById(ue_pk).getEnseignant();
        Double newEtd = enseignantService.getEtdPerEnseignantType(newEnseignant.getNo_Enseignant(), uniteEnseignement.getNbh_cm(),uniteEnseignement.getNbh_td(), uniteEnseignement.getNbh_tp());
        Double enseignant_etd = enseignantService.sumEtd(newEnseignant.getNo_Enseignant());

        if(newEtd + enseignant_etd <= 192){
            currentEnseignant.getUniteEnseignementSet().remove(uniteEnseignement);
            newEnseignant.getUniteEnseignementSet().add(uniteEnseignement);
            uniteEnseignement.setEnseignant(newEnseignant);
            enseignantRepository.save(newEnseignant);
            return uniteEnseignementRepository.save(uniteEnseignement);
        }else
            throw new ExceedETDException(Enseignant.class, newEnseignant.getNo_Enseignant().toString());
    }


    @Override
    public Double getCurrentEtdSum(UniteEnseignementPK ue_pk, Long id){
        var uniteEnseignement = uniteEnseignementRepository.getById(ue_pk);
        Double ens_etd = enseignantService.sumEtd(id);
        Double ue_etd = uniteEnseignement.getNbh_etd();
        Double result = ens_etd + ue_etd;
        return result;

    }

    public boolean enseignantExists(Long noEnseignant) throws EntityNotFoundException {
        return enseignantRepository.findById(noEnseignant).isPresent();
    }
}
