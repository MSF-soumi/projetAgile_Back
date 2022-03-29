package com.application.services;

import java.util.List;

import com.application.models.Enseignant;

public interface EnseignantService {

	public Enseignant create(Enseignant ens);
	
	public List<Enseignant> getAll();
	
	public Enseignant getById(Long id);
	
	public Enseignant update(Enseignant enseignant);
	
	public boolean delete(Long id);

	public Double sumEtd(Long id);

	public Double getEtdPerEnseignantType(Long id, int nbh_cm, int nbh_td, int nbh_tp);

	public Enseignant calculerEtd(Enseignant enseignant);

	public Enseignant getByEmailUbo(String emailUbo);

	public Enseignant updateById(Long id, Enseignant enseignantRequest);
	
}
