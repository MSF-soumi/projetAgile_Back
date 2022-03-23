package com.application.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.models.Enseignant;
import com.application.models.Etudiant;
import com.application.repositories.EtudiantRepository;
import com.application.services.EtudiantService;

@Service
public class EtudiantServiceImp implements EtudiantService{
	
	@Autowired
	private final EtudiantRepository etudiantRepository;
	
	public EtudiantServiceImp(EtudiantRepository etudiantRepo) {
		etudiantRepository=etudiantRepo;
	}

	@Override
	public List<Etudiant> getAll() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant getById(String id) {
		// TODO Auto-generated method stub
		Optional<Etudiant> res = etudiantRepository.findById(id);
		return res.isPresent() ? res.get() : null;

	}

}
