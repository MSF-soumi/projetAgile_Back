package com.application.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.EnseignantDTO;
import com.application.dto.PromotionDTO;
import com.application.models.Enseignant;
import com.application.models.Promotion;
import com.application.services.EnseignantService;
import com.application.services.Impl.EnseignantServiceImp;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {
	
	private final ModelMapper modelMapper;
	@Autowired
	private EnseignantService enseignantService;
	
	
    public EnseignantController(EnseignantService enseignantService,ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
    	this.enseignantService=enseignantService;
	}

	private EnseignantDTO convertToDto(Enseignant enseignant) {
        return modelMapper.map(enseignant, EnseignantDTO.class);
    }

    private Enseignant convertToEntity(EnseignantDTO enseignantDTO) {
        return modelMapper.map(enseignantDTO, Enseignant.class);
    }
}
