package com.application.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.models.Pays;
import com.application.repositories.PaysRepository;
import com.application.services.PaysService;

@Service
public class PaysServiceImp implements PaysService {
	
	@Autowired 
	private final PaysRepository paysRepository;
	
	public PaysServiceImp(PaysRepository paysRepository) {
		this.paysRepository=paysRepository;
	}
	

	@Override
	public List<Pays> getAll() {
		// TODO Auto-generated method stub
		return paysRepository.findAll();
	}

}
