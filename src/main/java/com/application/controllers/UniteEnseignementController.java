package com.application.controllers;

import com.application.dto.PromotionDTO;
import com.application.dto.UniteEnseignementDTO;
import com.application.exceptions.EntityNotFoundException;
import com.application.models.Promotion;
import com.application.models.UniteEnseignement;
import com.application.services.UniteEnseignementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private UniteEnseignementDTO convertToDto(UniteEnseignement uniteEnseignement) {
        return modelMapper.map(uniteEnseignement, UniteEnseignementDTO.class);
    }

}
