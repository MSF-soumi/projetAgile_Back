package com.application.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class SexeDTO {

	@NotBlank
	private String code;
	private String abreviation;
	private String signification;
}
