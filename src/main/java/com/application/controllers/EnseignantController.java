package com.application.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.services.EnseignantService;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {
	
	private EnseignantService enseignantService;
}
