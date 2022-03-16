package com.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TypeEnseignantDTO {

    @NotBlank
    private String code;
    @NotBlank
    private String abreviation;
    @NotBlank
    private String signification;
}
