package com.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
			@ApiResponse(code=400,message="Requette non réussie"),
			@ApiResponse(code=404,message="ID non trouvable")
	})
	@GetMapping(path = "/{id}")
	public ResponseEntity<EnseignantDTO> getById(@PathVariable Long id){
		System.out.println("console");

		var enseignant = enseignantService.getById(id);
		System.out.println("inside ish"+enseignant);

		if(enseignant==null){
			System.out.println("inside"+enseignant);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<>(this.convertToDto(enseignant), HttpStatus.OK);
		}
	}
	
	@ApiOperation(value="Rechercher un enseignant par emailUbo")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
	@GetMapping(path = "emailUbo/{emailUbo}")
	public EnseignantDTO getByEmailUbo(@PathVariable String emailUbo){
		var enseignant = enseignantService.getByEmailUbo(emailUbo);
		return this.convertToDto(enseignant);
	}
	@ApiOperation(value="Créer un enseignant")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})	
	@PostMapping
	public EnseignantDTO createEnseignant(@RequestBody Enseignant enseignantRequest) {
		var enseignant = enseignantService.create(enseignantRequest);
		return this.convertToDto(enseignant);
		
	}
	@ApiOperation(value="Supprimer un enseignant")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})	
	@DeleteMapping(path="/{noEnseignant}")
    public void deleteByNoEnseignant(@PathVariable("noEnseignant") Long noEnseignant){
        try {
        	enseignantService.delete(noEnseignant);
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }
	private EnseignantDTO convertToDto(Enseignant enseignant) {
		return modelMapper.map(enseignant, EnseignantDTO.class);
	}
	
	private Enseignant convertToEntity(EnseignantDTO enseignantDTO) {
		return modelMapper.map(enseignantDTO, Enseignant.class);
	}
}