package com.application.services;

import java.util.List;

import com.application.models.Enseignant;

<<<<<<< Updated upstream
@Service
public class EnseignantService {
	@Autowired
	private EnseignantRepository enseignantRepository;
		
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
=======
public interface EnseignantService {
>>>>>>> Stashed changes
	
	public Enseignant create(Enseignant ens);
	
	public List<Enseignant> getAll();
	
	public Enseignant getById(Long id);
	
	public Enseignant update(Enseignant enseignant);
	
	public void delete(Long id);
}
