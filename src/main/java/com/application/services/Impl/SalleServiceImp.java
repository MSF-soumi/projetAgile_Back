package com.application.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.models.Salle;
import com.application.repositories.SalleRepository;
import com.application.services.SalleService;


@Service
public class SalleServiceImp implements SalleService{

	@Autowired
	SalleRepository salleRepository;
	
	@Override
	public List<Salle> getAll() {
		return salleRepository.findAll();
	}

}
