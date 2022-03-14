package com.application.controllers;

import com.application.dto.PromotionDTO;
import com.application.models.Promotion;
import com.application.models.PromotionPK;
import com.application.services.PromotionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/promotions")
@CrossOrigin(origins = "*")

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
            @ApiResponse(code=200,message="Requêtte réussie"),
            @ApiResponse(code=500,message="Erreur serveur, Réessayez!"),
            @ApiResponse(code=400,message="Requêtte non réussie")
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

    @PutMapping
    public List<PromotionDTO> updateWorkflow(@Valid @RequestBody List<PromotionDTO> promotionDTOList){
        var promotionList = convertListToEntity(promotionDTOList);
        var newPromotionList = promotionService.updateWorkflow(promotionList);
        return convertListToDto(newPromotionList);
    }

    private PromotionDTO convertToDto(Promotion promotion) {
        return modelMapper.map(promotion, PromotionDTO.class);
    }

    private List<PromotionDTO> convertListToDto(List<Promotion> promotions) {
        List<PromotionDTO> promotionDTOList = new ArrayList<>();
        for (Promotion promotion:promotions) {
            promotionDTOList.add(modelMapper.map(promotions, PromotionDTO.class));
        }
        return promotionDTOList;
    }

    private List<Promotion> convertListToEntity(List<PromotionDTO> promotionsDTO) {
        List<Promotion> promotionList = new ArrayList<>();
        for (PromotionDTO promotionDTO:promotionsDTO) {
            promotionList.add(modelMapper.map(promotionDTO, Promotion.class));
        }
        return promotionList;
    }

    private Promotion convertToEntity(PromotionDTO promotionDTO) {
        return modelMapper.map(promotionDTO, Promotion.class);
    }


}
