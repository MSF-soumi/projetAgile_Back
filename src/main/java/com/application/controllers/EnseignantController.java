package com.application.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.EnseignantDTO;
import com.application.models.Enseignant;
import com.application.services.Impl.EnseignantServiceImp;
import com.fasterxml.jackson.databind.util.JSONPObject;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
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
			@ApiResponse(code=200,message="Requêtte réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
			@ApiResponse(code=400,message="Requêtte non réussie")
	})
	@GetMapping
	public List<EnseignantDTO> getAll(){
		var enseignants = enseignantService.getAll();
		return enseignants.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@ApiOperation(value="Rechercher un enseignant par ID")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requêtte réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
			@ApiResponse(code=400,message="Requêtte non réussie")
	})
	@GetMapping(path = "/{id}")
	public ResponseEntity<EnseignantDTO> getById(@Valid@PathVariable Long id){
		var enseignant = enseignantService.getById(id);
		if (enseignant==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(this.convertToDto(enseignant), HttpStatus.OK);

	}
	
	@ApiOperation(value="Rechercher un enseignant par emailUbo")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requêtte réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
			@ApiResponse(code=400,message="Requêtte non réussie")
	})
	@GetMapping(path = "emailUbo/{emailUbo}")
	public ResponseEntity<EnseignantDTO> getByEmailUbo(@Valid@PathVariable String emailUbo){
		var enseignant = enseignantService.getByEmailUbo(emailUbo);
		if (enseignant==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(this.convertToDto(enseignant), HttpStatus.OK);
	}

	@ApiOperation(value="Créer un enseignant")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requêtte réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
			@ApiResponse(code=400,message="Requêtte non réussie")
	})	
	@PostMapping
	public EnseignantDTO createEnseignant(@Valid@RequestBody EnseignantDTO enseignantRequest) {
		Enseignant enseignant = convertToEntity(enseignantRequest);
		var newEnseignant = enseignantService.create(enseignant);
		return this.convertToDto(newEnseignant);
	}

	@ApiOperation(value="Supprimer un enseignant")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requêtte réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
			@ApiResponse(code=400,message="Requêtte non réussie")
	})	
	@DeleteMapping(path="/{noEnseignant}")
    public ResponseEntity<?> deleteByNoEnseignant(@Valid@PathVariable("noEnseignant") Long noEnseignant) {
		Boolean val=enseignantService.delete(noEnseignant);
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("message", "Entity deleted");
		if (val) return ResponseEntity.ok(map);
		else return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<EnseignantDTO> updateEnseignant(@Valid@PathVariable Long id,@Valid@RequestBody EnseignantDTO enseignantRequest) {
		Enseignant enseignant = convertToEntity(enseignantRequest);
		var newEnseignant = enseignantService.updateById(id,enseignant);
		if (newEnseignant==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
//	            enseignantService.createEnseignant(enseignant);
		return new ResponseEntity<>(convertToDto(newEnseignant), HttpStatus.OK);
		//  return convertToDto(newEnseignant);
	}

	private EnseignantDTO convertToDto(Enseignant enseignant) {
		return modelMapper.map(enseignant, EnseignantDTO.class);
	}
	
	private Enseignant convertToEntity(EnseignantDTO enseignantDTO) {
		return modelMapper.map(enseignantDTO, Enseignant.class);
	}
}
