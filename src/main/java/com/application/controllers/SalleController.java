package com.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.SalleDTO;
import com.application.models.Salle;
import com.application.services.SalleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/salles")
@CrossOrigin(origins = "*")

public class SalleController {
	
	private final ModelMapper modelMapper;
	
	@Autowired
	public final SalleService salleService;

	/**
	 * @param modelMapper
	 * @param salleService
	 */
	public SalleController(ModelMapper modelMapper, SalleService salleService) {
		super();
		this.modelMapper = modelMapper;
		this.salleService = salleService;
	}
	
	
	@ApiOperation(value="Lister toutes les salles")
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "Requete réussie"),
			@ApiResponse(code=500, message = "Erreur Serveur, Réessayez"),
			@ApiResponse(code=400, message = "Requete non réussie"),
	})
	@GetMapping
	public List<SalleDTO> getAll(){
		var salles = salleService.getAll();
		return salles.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	private SalleDTO convertToDto(Salle salle) {
		return modelMapper.map(salle, SalleDTO.class);
	}
	
	
	
	
	
	
	
}
