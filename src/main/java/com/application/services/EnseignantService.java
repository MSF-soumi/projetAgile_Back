package com.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.models.Enseignant;
import com.application.repositories.EnseignantRepository;


@Service
public class EnseignantService {
	private final EnseignantRepository enseignantRepository ;
		
	public EnseignantService(EnseignantRepository enseignantRepo) {
		
		enseignantRepository=enseignantRepo;
	}
	public Enseignant create(Enseignant ens)
	{
		Enseignant newEns=new Enseignant(ens.getNo_Enseignant() , ens.getNom(), ens.getPrenom(), ens.getSexe(), ens.getType(), ens.getPays(),
				ens.getVille(), ens.getAdresse(), ens.getEmail_Perso(), ens.getEmail_Ubo(), ens.getMobile(), ens.getTelephone(),
				ens.getCode_Postal());
		enseignantRepository.save(newEns);
		return newEns;
	}
	public List<Enseignant> getAll()
	{
		return enseignantRepository.findAll();
	}
	
	public Enseignant getById(Long id)
	{
		return enseignantRepository.getById(id);
	}
	
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
	
	public void delete(Long id)
	{
		enseignantRepository.deleteById(id);
	}

}
