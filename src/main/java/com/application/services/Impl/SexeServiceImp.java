package com.application.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.models.Sexe;
import com.application.repositories.SexeRepository;
import com.application.services.SexeService;
@Service
public class SexeServiceImp implements SexeService {
	
	@Autowired
	private final SexeRepository sexeRepository;
	
	public SexeServiceImp(SexeRepository sexeRepository) {
		this.sexeRepository=sexeRepository;
	}

	@Override
	public List<Sexe> getAll() {
		// TODO Auto-generated method stub
		return sexeRepository.findAll();
	}

}
