package com.application.controllers;

import com.application.dto.PromotionDTO;
import com.application.dto.UniteEnseignementDTO;
import com.application.models.Promotion;
import com.application.models.UniteEnseignement;
import com.application.services.UniteEnseignementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            @ApiResponse(code=200,message="Requette réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
            @ApiResponse(code=400,message="Requette non réussie")
    })
    @GetMapping
    public List<UniteEnseignementDTO> getAll() {
        var unitesEnseignement = uniteEnseignementService.getAll();
        return unitesEnseignement.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private UniteEnseignementDTO convertToDto(UniteEnseignement uniteEnseignement) {
        return modelMapper.map(uniteEnseignement, UniteEnseignementDTO.class);
    }
}
