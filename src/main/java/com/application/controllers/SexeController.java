package com.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.SexeDTO;
import com.application.models.Sexe;
import com.application.services.Impl.SexeServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/sexes")
public class SexeController {

	private final ModelMapper modelMapper;
    private SexeServiceImp sexeServiceImp;

    public SexeController(ModelMapper modelMapper, SexeServiceImp sexeServiceImp) {
        super();
        this.modelMapper = modelMapper;
        this.sexeServiceImp = sexeServiceImp;
    }

    @ApiOperation(value="Lister les sexes")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })

    @GetMapping
    public List<SexeDTO> getAll() {
        var sexes = sexeServiceImp.getAll();
        return sexes.stream().map(this::convertToDto).collect(Collectors.toList());    }

    private SexeDTO convertToDto(Sexe sexe) {
        return modelMapper.map(sexe, SexeDTO.class);
    }

    private Sexe convertToEntity(SexeDTO sexeDTO) {
        return modelMapper.map(sexeDTO, Sexe.class);
    }
}
