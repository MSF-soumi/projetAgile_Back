package com.application.controllers;

import com.application.dto.UniteEnseignementDTO;
import com.application.models.UniteEnseignement;
import com.application.models.UniteEnseignementPK;
import com.application.services.UniteEnseignementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/unitesenseignement")
public class UniteEnseignementController {

    private final ModelMapper modelMapper;

    @Autowired
    public final UniteEnseignementService uniteEnseignementService;


    public UniteEnseignementController(ModelMapper modelMapper, UniteEnseignementService uniteEnseignementService) {
        this.modelMapper = modelMapper;
        this.uniteEnseignementService = uniteEnseignementService;
    }

    @ApiOperation(value="Lister toutes les unités d'enseignement")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping
    public List<UniteEnseignementDTO> getAll() {
        var unitesEnseignement = uniteEnseignementService.getAll();
        return unitesEnseignement.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @ApiOperation(value="Lister toutes les unités d'enseignement")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping(path = "/enseignant/{noEnseignant}")
    public List<UniteEnseignementDTO> getUEByNoEnseignant(@PathVariable Long noEnseignant) {
        var unitesEnseignement = uniteEnseignementService.getUEByEnseignant(noEnseignant);
        return unitesEnseignement.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @ApiOperation(value="Récupérer une unité d'enseignement par ID")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping(path = "/{code_Formation}/{code_ue}")
    public UniteEnseignementDTO getById(@PathVariable String code_Formation,@PathVariable String code_ue){
        UniteEnseignementPK id= new UniteEnseignementPK(code_Formation,code_ue);
        var uniteenseignement = uniteEnseignementService.getById(id);
        return this.convertToDto(uniteenseignement);
    }
    
    @GetMapping(path = "/enseignant/etd/{noEnseignant}")
    public double getSumEtd(Long noEnseignant) {
    	return uniteEnseignementService.getSumEtd(noEnseignant);
    }



    @PutMapping(path="/enseignant/etd/{noEnseignant}")
    public ResponseEntity<UniteEnseignementDTO> updateUE(@Valid @RequestBody UniteEnseignementDTO uniteEnseignement){
        UniteEnseignement UE = convertToEntity(uniteEnseignement);
        UniteEnseignement ue= uniteEnseignementService.updateUE(UE);
        if (ue==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(convertToDto(ue), HttpStatus.OK);
    }

    private UniteEnseignementDTO convertToDto(UniteEnseignement uniteEnseignement) {
        return modelMapper.map(uniteEnseignement, UniteEnseignementDTO.class);
    }
    private UniteEnseignement convertToEntity(UniteEnseignementDTO uniteEnseignementDTO) {
        return modelMapper.map(uniteEnseignementDTO, UniteEnseignement.class);
    }
}
