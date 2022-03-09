package com.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.models.Enseignant;
import com.application.repositories.EnseignantRepository;


@Service
public class EnseignantService {
	@Autowired
	private EnseignantRepository enseignantRepository;
		
	public Enseignant create(Enseignant ens)
	{
		Enseignant newEns=new Enseignant(ens.getNoEnseignant() , ens.getNom(), ens.getPrenom(), ens.getSexe(), ens.getType(), ens.getPays(),
				ens.getVille(), ens.getAdresse(), ens.getEmailPerso(), ens.getEmailUbo(), ens.getMobile(), ens.getTelephone(),
				ens.getCodePostal());
		enseignantRepository.save(newEns);
		return newEns;
	}
	public List<Enseignant> getAll()
	{
		return enseignantRepository.findAll();
	}
	
	public Enseignant getById(int id)
	{
		return enseignantRepository.getById(id);
	}
	
	public Enseignant update(Enseignant enseignant) {
		Enseignant Enseignant=enseignantRepository.getById(enseignant.getNoEnseignant());
		Enseignant.setNom(enseignant.getNom());
		Enseignant.setPrenom(enseignant.getPrenom());
		Enseignant.setSexe(enseignant.getSexe());
		Enseignant.setType(enseignant.getType());
		Enseignant.setPays(enseignant.getPays());
		Enseignant.setVille(enseignant.getVille());
		Enseignant.setAdresse(enseignant.getAdresse());
		Enseignant.setEmailPerso(enseignant.getEmailPerso());
	//	Enseignant.setEmailUbo(enseignant.getEmailUbo()); *non modifiable
		Enseignant.setMobile(enseignant.getMobile());
		Enseignant.setTelephone(enseignant.getTelephone());
		Enseignant.setCodePostal(enseignant.getCodePostal());
		return enseignantRepository.save(Enseignant);
	}
	
	public void delete(int id)
	{
		enseignantRepository.deleteById(id);
	}

}
