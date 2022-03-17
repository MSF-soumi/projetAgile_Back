package com.application.controllers;

import com.application.dto.FormationDTO;
import com.application.models.Formation;
import com.application.services.Impl.FormationServiceImp;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/formations")
public class FormationController {

    private final ModelMapper modelMapper;
    private FormationServiceImp formationServiceImp;

    public FormationController(ModelMapper modelMapper, FormationServiceImp formationServiceImp) {
        super();
        this.modelMapper = modelMapper;
        this.formationServiceImp = formationServiceImp;
    }

    @ApiOperation(value="Lister toutes les formations")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping
    public List<FormationDTO> getAll() {
        var formations = formationServiceImp.getAll();
        return formations.stream().map(this::convertToDto).collect(Collectors.toList());    }

    private FormationDTO convertToDto(Formation formation) {
        return modelMapper.map(formation, FormationDTO.class);
    }

    private Formation convertToEntity(FormationDTO formationDTO) {
        return modelMapper.map(formationDTO, Formation.class);
    }
}

