package com.application.services.Impl;

import java.util.List;

import com.application.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.models.Enseignant;
import com.application.repositories.EnseignantRepository;


@Service
public class EnseignantServiceImp implements EnseignantService {
	
	@Autowired
	private final EnseignantRepository enseignantRepository ;
		
	public EnseignantServiceImp(EnseignantRepository enseignantRepo) {
		
		enseignantRepository=enseignantRepo;
	}
	
	@Override
	public Enseignant create(Enseignant ens)
	{
		Enseignant newEns=new Enseignant(ens.getNo_Enseignant() , ens.getNom(), ens.getPrenom(), ens.getSexe(), ens.getType(), ens.getPays(),
				ens.getVille(), ens.getAdresse(), ens.getEmail_Perso(), ens.getEmail_Ubo(), ens.getMobile(), ens.getTelephone(),
				ens.getCode_Postal());
		enseignantRepository.save(newEns);
		return newEns;
	}
	@Override
	public List<Enseignant> getAll()
	{
		return enseignantRepository.findAll();
	}
	
	@Override
	public Enseignant getById(Long id)
	{
		return enseignantRepository.getById(id);
	}
	
	@Override
	public Enseignant update(Enseignant enseignant) {
		Enseignant Enseignant=enseignantRepository.getById(enseignant.getNo_Enseignant());
		Enseignant.setNom(enseignant.getNom());
		Enseignant.setPrenom(enseignant.getPrenom());
		Enseignant.setSexe(enseignant.getSexe());
		Enseignant.setType(enseignant.getType());
		Enseignant.setPays(enseignant.getPays());
		Enseignant.setVille(enseignant.getVille());
		Enseignant.setAdresse(enseignant.getAdresse());
		Enseignant.setEmail_Perso(enseignant.getEmail_Perso());
	//	Enseignant.setEmailUbo(enseignant.getEmailUbo()); *non modifiable
		Enseignant.setMobile(enseignant.getMobile());
		Enseignant.setTelephone(enseignant.getTelephone());
		Enseignant.setCode_Postal(enseignant.getCode_Postal());
		return enseignantRepository.save(Enseignant);
	}
	
	@Override
	public void delete(Long id)
	{
		enseignantRepository.deleteById(id);
	}
	@Override
	public Enseignant getByEmailUbo(String email_Ubo)
	{
		return enseignantRepository.findByEmail_Ubo(email_Ubo);
	}

}
