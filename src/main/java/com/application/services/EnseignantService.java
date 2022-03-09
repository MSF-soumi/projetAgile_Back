package com.application.services;

import java.util.List;

import com.application.models.Enseignant;

public interface EnseignantService {

	public Enseignant create(Enseignant ens);
	
	public List<Enseignant> getAll();
	
	public Enseignant getById(Long id);
	
	public Enseignant update(Enseignant enseignant);
	
	public void delete(Long id);
	
}
