package com.application.services.Impl;

import com.application.exceptions.EntityNotFoundException;
import com.application.exceptions.enseignant.EnseignantNotFoundException;
import com.application.exceptions.etudiant.DifferentIdRequestException;
import com.application.exceptions.ue.ExceedETDException;
import com.application.exceptions.ue.UENotFoundException;
import com.application.exceptions.ue.UeAlreadyBelongsToChosenTeacherException;
import com.application.models.Enseignant;
import com.application.models.UniteEnseignement;
import com.application.models.UniteEnseignementPK;
import com.application.repositories.EnseignantRepository;
import com.application.repositories.UniteEnseignementRepository;
import com.application.services.UniteEnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
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

//    @Override
//    public double getSumEtd(Long noEnseignant) {
//        return 0;
//    }

//    @Override
//    public UniteEnseignement updateUE(UniteEnseignement UE) {
//        //double nbh_etd=UE.getNbh_etd();
//        Long id = UE.getEnseignant().getNo_Enseignant();
//        System.out.println("this is id ens " + id);
////        System.out.println("hello");
////        var  UEens_list = getUEByEnseignant(id);
////
////        System.out.println("this is ens==> " + UEens_list);
//
//        var enseignant=enseignantService.getById(id);
//        System.out.println("this is ens==> "+enseignant);
//        Set<UniteEnseignement> UEens_set=enseignant.getUniteEnseignementSet();
//        for(UniteEnseignement ue : UEens_set){
//            System.out.println("ue "+ue.getNbhEtd());
//        }
//
//
////        double nbh_etd_ens=0;
////        for(int i=0;i<UEens_list.size();i++){
////           nbh_etd_ens+= UEens_set.stream().map((e)=> e.getNbh_etd())
////        }
////        nbh_etd_ens+=getDiffupdatedUE(UE);
////
////        if(nbh_etd_ens <= 192)
////            return uniteEnseignementRepository.save(UE);
////        else throw new ExceedETDException(UniteEnseignement.class,id.toString());
//return UE;
//    }

    //    public double getDiffupdatedUE(UniteEnseignement UE){
//        double new_etd=UE.getNbh_etd();
//        UniteEnseignement old_UE=uniteEnseignementRepository.findUniteEnseignementsById(UE.getId());
//        double old_etd=old_UE.getNbh_etd();
//        double diff=new_etd-old_etd;
//        return diff;
//
//    }


    @Override
    public UniteEnseignement updateUE(UniteEnseignementPK id,UniteEnseignement ue){
        var uniteEnseignement = uniteEnseignementRepository.getById(id);
        var currentEnseignant = new Enseignant();
        var newEnseignant = ue.getEnseignant();
        if(uniteEnseignementRepository.getById(id).getEnseignant() != null){
            currentEnseignant = uniteEnseignementRepository.getById(id).getEnseignant();
        }
        try
        {

               var id_ens_old=uniteEnseignement.getEnseignant().getNo_Enseignant();
               var id_ens_new=ue.getEnseignant().getNo_Enseignant();
                Double newEtd = getEtdPerEnseignantType(newEnseignant.getNo_Enseignant(), ue.getNbh_Cm(),ue.getNbh_Td(), ue.getNbh_Tp());
                Double enseignant_etd = enseignantService.sumEtd(newEnseignant.getNo_Enseignant());
                Double somme = newEtd + enseignant_etd;
                System.out.println("newEtd: "+ newEtd + "enseignantEtd: " + enseignant_etd + "somme: " + somme );
                if(somme > 192) {
                    throw new ExceedETDException(Enseignant.class, newEnseignant.getNo_Enseignant().toString());
                }
                else{
                    if(!id_ens_old.equals(id_ens_new)) {
                    uniteEnseignement.setEnseignant(newEnseignant);
                    currentEnseignant.getUniteEnseignementSet().remove(uniteEnseignement);
                    newEnseignant.getUniteEnseignementSet().add(uniteEnseignement);
                }
                    uniteEnseignement.setDesignation(ue.getDesignation());
                    uniteEnseignement.setSemestre(ue.getSemestre());
                    uniteEnseignement.setDescription(ue.getDescription());
                    uniteEnseignement.setNbh_Cm(ue.getNbh_Cm());
                    uniteEnseignement.setNbh_Td(ue.getNbh_Td());
                    uniteEnseignement.setNbh_Tp(ue.getNbh_Tp());
                    uniteEnseignement.setNbh_Etd(ue.getNbh_Etd());
                }
            return uniteEnseignementRepository.save(ue);

        } catch (DifferentIdRequestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean differentId(UniteEnseignementPK id,UniteEnseignement ue){

        if(this.getById(id) == null){

            throw new UENotFoundException(UniteEnseignement.class, id);
        }
        else {

            if(!id.equals(ue.getId()))
                throw new DifferentIdRequestException(UniteEnseignement.class, id.getCode_Formation().toString());
            else return true;
        }

    }

   /* @Override
    public void updateEnseignantUE(UniteEnseignementPK ue_pk, Enseignant newEnseignant){
        var uniteEnseignement = uniteEnseignementRepository.getById(ue_pk);
        var currentEnseignant = new Enseignant();
        if(uniteEnseignementRepository.getById(ue_pk).getEnseignant() != null){
            currentEnseignant = uniteEnseignementRepository.getById(ue_pk).getEnseignant();
        }
        Double newEtd = getEtdPerEnseignantType(newEnseignant.getNo_Enseignant(), uniteEnseignement.getNbh_Cm(),uniteEnseignement.getNbh_Td(), uniteEnseignement.getNbh_Tp());
        Double enseignant_etd = enseignantService.sumEtd(newEnseignant.getNo_Enseignant());
        System.out.println("sum1=> "+ enseignant_etd);
        System.out.println("sum2=> "+ newEtd);
        System.out.println("sum=> "+ newEtd + enseignant_etd);
        if(newEtd + enseignant_etd <= 192.0){
            uniteEnseignement.setEnseignant(newEnseignant);
            currentEnseignant.getUniteEnseignementSet().remove(uniteEnseignement);
            newEnseignant.getUniteEnseignementSet().add(uniteEnseignement);
        }else
            throw new ExceedETDException(Enseignant.class, newEnseignant.getNo_Enseignant().toString());
    }*/


    @Override
    public Double getCurrentEtdSum(UniteEnseignementPK ue_pk, Long id){
        var uniteEnseignement = uniteEnseignementRepository.getById(ue_pk);
        Double ens_etd = enseignantService.sumEtd(id);
        Double ue_etd = uniteEnseignement.getNbh_Etd();
        Double result = ens_etd + ue_etd;
        return result;

    }

    @Override
    public Double getEtdPerEnseignantType(Long id, int nbh_cm, int nbh_td, int nbh_tp){
        if(enseignantRepository.existsById(id)) {
            var enseignant = enseignantRepository.getById(id);
            Double etd = 0.00;
            if (enseignant.getType().getCode().equals("INT"))
                etd = nbh_cm * 1.5 + nbh_td + (double)nbh_tp * 2/3;
            else {
                System.out.println("inside");
                etd = nbh_cm * 1.5 + nbh_td + (double)nbh_tp;
            }

            System.out.println("cm"+nbh_cm);
            System.out.println("td"+nbh_td);
            System.out.println("tp"+nbh_tp);
            System.out.println(Math.round(etd* 2) / 2.0);
            System.out.println("ETD++>"+Math.round(etd* 2) / 2.0);
            return Math.round(etd* 2) / 2.0;
        }
        else throw new EnseignantNotFoundException(Enseignant.class, id);
    }

    public boolean enseignantExists(Long noEnseignant) throws EntityNotFoundException {
        return enseignantRepository.findById(noEnseignant).isPresent();
    }

    @Override
    public List<UniteEnseignement> findByPromo(String code_Formation) {
        // TODO Auto-generated method stub
        return uniteEnseignementRepository.findByPromo(code_Formation);
    }
    public boolean NumberFormat(int nbr)  {
            if(nbr==(int)(nbr))
                return true;
        return false;

    }

//	@Override
//	public double getSumEtd(Long noEnseignant)
//	{
//		List<UniteEnseignement> list =getUEByEnseignant(noEnseignant);
//		double res=0;
//		// TODO Auto-generated method stub
//		for (UniteEnseignement ue : list) {
//	          res+=ue.getNbh_etd();
//	      }
//		System.out.println(res);
//		return res;
//	}

}
