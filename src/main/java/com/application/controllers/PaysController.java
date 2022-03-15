package com.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.PaysDTO;
import com.application.models.Pays;
import com.application.services.Impl.PaysServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/pays")
public class PaysController {
	
	private final ModelMapper modelMapper;
    private PaysServiceImp paysServiceImp;

    public PaysController(ModelMapper modelMapper, PaysServiceImp paysServiceImp) {
        super();
        this.modelMapper = modelMapper;
        this.paysServiceImp = paysServiceImp;
    }

    @ApiOperation(value="Lister les pays")
    @ApiResponses(value= {
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
    })

    @GetMapping
    public List<PaysDTO> getAll() {
        var pays = paysServiceImp.getAll();
        return pays.stream().map(this::convertToDto).collect(Collectors.toList());    }

    private PaysDTO convertToDto(Pays pays) {
        return modelMapper.map(pays, PaysDTO.class);
    }

    private Pays convertToEntity(PaysDTO paysDTO) {
        return modelMapper.map(paysDTO, Pays.class);
    }

}
