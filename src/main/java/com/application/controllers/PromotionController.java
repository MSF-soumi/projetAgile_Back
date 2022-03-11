package com.application.controllers;

import com.application.dto.PromotionDTO;
import com.application.models.Promotion;
import com.application.models.PromotionPK;
import com.application.services.PromotionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/promotions")
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
