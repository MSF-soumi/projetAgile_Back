package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.services.Impl.EnseignantServiceImp;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {
	
	private EnseignantServiceImp enseignantService;
}
