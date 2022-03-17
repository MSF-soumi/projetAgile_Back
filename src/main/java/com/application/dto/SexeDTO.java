package com.application.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class SexeDTO {

	@NotBlank
	private String code;
	private String abreviation;
	private String signification;
}
