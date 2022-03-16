package com.application.controllers;

import com.application.dto.TypeEnseignantDTO;
import com.application.models.TypeEnseignant;
import com.application.services.Impl.TypeEnseignantServiceImp;
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
@RequestMapping("/api/v1/typeenseignant")
public class TypeEnseignantController {

    private final ModelMapper modelMapper;
    private TypeEnseignantServiceImp typeEnseignantServiceImp;

    public TypeEnseignantController(ModelMapper modelMapper, TypeEnseignantServiceImp typeEnseignantServiceImp) {
        super();
        this.modelMapper = modelMapper;
        this.typeEnseignantServiceImp = typeEnseignantServiceImp;
    }

    @ApiOperation(value="Lister toutes les types d'enseignants")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })
    @GetMapping
    public List<TypeEnseignantDTO> getAll() {
        var typesenseignant = typeEnseignantServiceImp.getAll();
        return typesenseignant.stream().map(this::convertToDto).collect(Collectors.toList());    }

    private TypeEnseignantDTO convertToDto(TypeEnseignant typeEnseignant) {
        return modelMapper.map(typeEnseignant, TypeEnseignantDTO.class);
    }

    private TypeEnseignant convertToEntity(TypeEnseignantDTO typeEnseignantDTO) {
        return modelMapper.map(typeEnseignantDTO, TypeEnseignant.class);
    }
}
