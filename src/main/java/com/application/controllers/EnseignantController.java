package com.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.EnseignantDTO;
import com.application.models.Enseignant;
import com.application.services.Impl.EnseignantServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/enseignants")
public class EnseignantController {
	
	private final ModelMapper modelMapper;
	
	private EnseignantServiceImp enseignantService;

	public EnseignantController(ModelMapper modelMapper, EnseignantServiceImp enseignantService) {
		super();
		this.modelMapper = modelMapper;
		this.enseignantService = enseignantService;
	}
	@ApiOperation(value="Lister tous les enseignants")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
	@GetMapping
	public List<EnseignantDTO> getAll(){
		var enseignants = enseignantService.getAll();
		return enseignants.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@ApiOperation(value="Rechercher un enseignant par ID")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
	@GetMapping(path = "/{id}")
	public EnseignantDTO getById(@PathVariable Long id){
		var enseignant = enseignantService.getById(id);
		return this.convertToDto(enseignant);
	}
	
	private EnseignantDTO convertToDto(Enseignant enseignant) {
		return modelMapper.map(enseignant, EnseignantDTO.class);
	}
	
	private Enseignant convertToEntity(EnseignantDTO enseignantDTO) {
		return modelMapper.map(enseignantDTO, Enseignant.class);
	}
}