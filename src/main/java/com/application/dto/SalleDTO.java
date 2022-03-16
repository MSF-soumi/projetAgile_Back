package com.application.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SalleDTO {
	
	@NotBlank
	private String code;
	private String abreviation;
	private String signification;

}