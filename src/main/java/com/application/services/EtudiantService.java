package com.application.services;

import java.util.List;

import com.application.models.Etudiant;


public interface EtudiantService {
	
	public List<Etudiant> getAll();
	
	public Etudiant getById(String id);
	
	public List<Etudiant> findByPromo(String code_Formation,String annee_Universitaire);

	public boolean deleteById(String id);

}
