package com.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class FormationDTO {

    @NotBlank
    private String code_Formation;

    @NotBlank
    private String diplome;

    private Long n0_Annee;

    @NotBlank
    private String nom_Formation;

    @NotBlank
    private String double_Diplome;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    private LocalDate debut_Accreditation;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    private LocalDate fin_Accreditation;
}
