package com.application.services.Impl;

import com.application.exceptions.promotions.EntityNotFoundException;
import com.application.models.*;
import com.application.repositories.*;
import com.application.services.PromotionService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class PromotionServiceImp implements PromotionService {

    @Autowired
    public final PromotionRepository promotionRepository;
    public final EnseignantRepository enseignantRepository;
    public final FormationRepository formationRepository;
    public final SalleRepository salleRepository;
    public final ProcessusStageRepository processusStageRepository;

    public PromotionServiceImp(PromotionRepository promotionRepository, EnseignantRepository enseignantRepository, FormationRepository formationRepository, SalleRepository salleRepository, ProcessusStageRepository processusStageRepository) {
        this.promotionRepository = promotionRepository;
        this.enseignantRepository = enseignantRepository;
        this.formationRepository = formationRepository;
        this.salleRepository = salleRepository;
        this.processusStageRepository = processusStageRepository;
    }

    @Override
    public Promotion create(Promotion promotion) {
        if (promotion.getProcessus_Stage() == null)
            promotion.setProcessus_Stage("RECH");
        Long noEnseignant = promotion.getEnseignant().getNo_Enseignant();
        if (!enseignantExists(noEnseignant)) throw new EntityNotFoundException(Enseignant.class, "Numéro Enseignant", noEnseignant.toString());
        if (!formationExists(promotion.getId().getCode_Formation())) throw new EntityNotFoundException(Formation.class, "Code Formation", promotion.getId().getCode_Formation());
        if (!salleExists(promotion.getLieu_Rentree())) throw new EntityNotFoundException(Salle.class, "Code", promotion.getLieu_Rentree());
        if (!processusStageExists(promotion.getProcessus_Stage())) throw new EntityNotFoundException(ProcessusStage.class, "Code", promotion.getProcessus_Stage());
        return this.promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> getAll(){
        return promotionRepository.findAll();
    } 
	@Override
	public Promotion getById(PromotionPK id)
	{
		Optional<Promotion> res=promotionRepository.findById(id);
		return res.isPresent()?res.get():null;
	}
    @Override
    public List<Promotion> updateWorkflow(List<Promotion> promotions){
        for(Promotion promotion: promotions){
            var oldPromotion = promotionRepository.getById(promotion.getId());
            oldPromotion.setProcessus_Stage(promotion.getProcessus_Stage());
            promotionRepository.save(promotion);
        }
        return promotionRepository.findAll();
    }

	@Override
	public boolean delete(PromotionPK id) {
		try{
			promotionRepository.deleteById(id);
			System.out.println("delete passed ");
			return true;
		}catch (Exception e){
			System.out.println("Exception "+e.getMessage());
			return false;
		}
		
	}

    public boolean enseignantExists(Long noEnseignant) throws EntityNotFoundException{
        return enseignantRepository.findById(noEnseignant).isPresent();
    }

    public boolean formationExists(String codeFormation) throws EntityNotFoundException{
        return formationRepository.findByCode_Formation(codeFormation) != null;
    }

    public boolean salleExists(String code) throws EntityNotFoundException{
        return salleRepository.findByCode(code) != null;
    }

    public boolean processusStageExists(String code) throws EntityNotFoundException{
        return processusStageRepository.findByCode(code) != null;
    }
}
