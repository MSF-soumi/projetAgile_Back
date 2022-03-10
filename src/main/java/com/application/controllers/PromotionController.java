package com.application.controllers;

import com.application.dto.PromotionDTO;
import com.application.models.Promotion;
import com.application.services.PromotionService;
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

    @GetMapping
    public List<PromotionDTO> getAll(){
        var promotions = promotionService.getAll();
        return promotions.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @PostMapping()
    public PromotionDTO create(@Valid @RequestBody PromotionDTO promotionDTO){
        var promotion = convertToEntity(promotionDTO);
        var newPromotion = promotionService.create(promotion);
        return convertToDto(newPromotion);
    }

    private PromotionDTO convertToDto(Promotion promotion) {
        return modelMapper.map(promotion, PromotionDTO.class);
    }

    private Promotion convertToEntity(PromotionDTO promotionDTO) {
        return modelMapper.map(promotionDTO, Promotion.class);
    }


}
