package com.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application.dto.EtudiantDTO;
import com.application.models.Etudiant;
import com.application.services.Impl.EtudiantServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/etudiants")
public class EtudiantController {

private final ModelMapper modelMapper;
	
	private EtudiantServiceImp etudiantService;

	public EtudiantController(ModelMapper modelMapper, EtudiantServiceImp etudiantService) {
		super();
		this.modelMapper = modelMapper;
		this.etudiantService = etudiantService;
	}
	@ApiOperation(value="Lister tous les étudiants")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requêtte réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
			@ApiResponse(code=400,message="Requêtte non réussie")
	})
	@GetMapping
	public List<EtudiantDTO> getAll(){
		var etudiants = etudiantService.getAll();
		return etudiants.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@ApiOperation(value="Rechercher un étudiant par ID")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requêtte réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
			@ApiResponse(code=400,message="Requêtte non réussie")
	})
	@GetMapping(path = "/{id}")
	public ResponseEntity<EtudiantDTO> getById(@Valid@PathVariable String id){
		var etudiant = etudiantService.getById(id);
		if (etudiant==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(this.convertToDto(etudiant), HttpStatus.OK);

	}

	@ApiOperation(value="Lister les étudiants d'une promotion")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requêtte réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
			@ApiResponse(code=400,message="Requêtte non réussie")
	})
	@GetMapping(path = "/{code_Formation}/{annee_Universitaire}")
	public List<EtudiantDTO> getById(@PathVariable String code_Formation,@PathVariable String annee_Universitaire){
		var etudiants = etudiantService.findByPromo(code_Formation, annee_Universitaire);
		return etudiants.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<EtudiantDTO> updateEtudiant(@Valid@PathVariable String id,@Valid@RequestBody EtudiantDTO etudiantRequest){
		Etudiant etudiant = convertToEntity(etudiantRequest);
		var newEtudiant = etudiantService.updateById(id,etudiant);
		if(newEtudiant == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<>(convertToDto(newEtudiant), HttpStatus.OK);
	}


	@DeleteMapping(path="/{id}")
	public boolean deleteEtudiant(@PathVariable String id){
		return etudiantService.deleteById(id);
	}

	private EtudiantDTO convertToDto(Etudiant etudiant) {
		return modelMapper.map(etudiant, EtudiantDTO.class);
	}
	
	private Etudiant convertToEntity(EtudiantDTO etudiantDTO) {
		return modelMapper.map(etudiantDTO, Etudiant.class);
	}
}
