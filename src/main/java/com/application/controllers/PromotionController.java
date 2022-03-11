package com.application.controllers;

import com.application.dto.EnseignantDTO;
import com.application.dto.PromotionDTO;
import com.application.models.Promotion;
import com.application.models.PromotionPK;
import com.application.services.PromotionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/promotions/")
public class PromotionController {

    private final ModelMapper modelMapper;

    @Autowired
    public final PromotionService promotionService;

    public PromotionController(PromotionService promotionService,ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.promotionService = promotionService;
    }
	@ApiOperation(value="Lister toutes les promotions")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
    @GetMapping
    public List<PromotionDTO> getAll(){
        var promotions = promotionService.getAll();
        return promotions.stream().map(this::convertToDto).collect(Collectors.toList());
    }
	@ApiOperation(value="Créer une promotion")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
    @PostMapping()
    public PromotionDTO create(@Valid @RequestBody PromotionDTO promotionDTO){
        var promotion = convertToEntity(promotionDTO);
        var newPromotion = promotionService.create(promotion);
        return convertToDto(newPromotion);
    }
    
	@ApiOperation(value="Rechercher une promotion par ID")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Requette réussie"),
			@ApiResponse(code=500,message="Erreur serveur, Reessayez!"),
			@ApiResponse(code=400,message="Requette non réussie")
	})
	@GetMapping(path = "/{code_Formation}/{annee_Universitaire}")
	public PromotionDTO getById(@PathVariable String code_Formation,@PathVariable String annee_Universitaire){
		PromotionPK id= new PromotionPK(code_Formation,annee_Universitaire);
		var promotion = promotionService.getById(id);
		return this.convertToDto(promotion);
	}
    private PromotionDTO convertToDto(Promotion promotion) {
        return modelMapper.map(promotion, PromotionDTO.class);
    }

    private Promotion convertToEntity(PromotionDTO promotionDTO) {
        return modelMapper.map(promotionDTO, Promotion.class);
    }


}
