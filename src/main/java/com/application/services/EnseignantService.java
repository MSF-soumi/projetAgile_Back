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

	public Enseignant calculerEtd(Enseignant enseignant);

	Enseignant getByEmailUbo(String emailUbo);

	Enseignant updateById(Long id, Enseignant enseignantRequest);
	
}
