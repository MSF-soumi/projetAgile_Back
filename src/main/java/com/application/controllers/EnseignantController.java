package com.application.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.services.EnseignantServiceImp;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {
	
	private EnseignantServiceImp enseignantService;
}
