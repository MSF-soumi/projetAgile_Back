package com.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.controllers.EnseignantController;
import com.application.controllers.PromotionController;
import com.application.models.Enseignant;
import com.application.services.EnseignantService;
import com.application.services.PromotionService;

@SpringBootTest
class ProjetAgileApplicationTests {

	@Autowired
	EnseignantService enseignantService;
	
	@Autowired
	PromotionService promotionService; 
	
	@Autowired
	EnseignantController enseignantController;
	
	@Autowired
	PromotionController promotionController;
	
	
	@Test
	void contextLoads() throws Exception 
	{
		
		//test de service d'enseignant 
		assertThat(enseignantService).isNotNull();
		
		//test de service de promotion 
		assertThat(promotionService).isNotNull();
		
		//test de controller d'enseignant
		assertThat(enseignantController).isNotNull();
		
		//test de controller de promotion
		assertThat(promotionController).isNotNull();
		
	}
	
	//---------------- Enseignant ----------------------
	@Test
	public void verfierDonneeEnseignants()
	{
		assertThat(enseignantService.getAll()).isNotEmpty();
	}
	
	
	@Test
	public void verfierEnseignantParId()
	{
		assertThat(enseignantService.getById(Long.valueOf(1)).getNom()).isNotEmpty();
		assertThat(enseignantService.getById(Long.valueOf(99))).isEqualTo(null);
		
	}
	
	@Test
	public void verfierEnseignantParEmail()
	{
		assertThat(enseignantService.getByEmailUbo("ps@univ-brest.fr").getNom()).isNotEmpty();
	}
	
	@Test
	public void verfierAjoutEnseignant()
	{
		Enseignant enseignant = new Enseignant();
		
		enseignant.setNom("DDtest");
		enseignant.setPrenom("DDtest");
		enseignant.setVille("BREST");
		enseignant.setAdresse("73 avenue champs elysees test");
		enseignant.setEmail_Ubo("ddTest@univ-brest.fr");
		enseignant.setMobile("06.00.00.00.19");
		enseignant.setCode_Postal("29200");
		enseignant.setSexe("F");
		enseignant.setType("MCF");
		enseignant.setPays("FR");
		enseignant.setTelephone("02.08.01.67.32");
		
		
		enseignant = enseignantService.create(enseignant);
		
		assertThat(enseignantService.getById(enseignant.getNo_Enseignant()).getNom()).isNotNull();
		
		enseignantService.delete(enseignant.getNo_Enseignant());
		
		assertThat(enseignantService.getById(enseignant.getNo_Enseignant())).isNull();		
		
	}
	
//	@Test
//	public void verfierSuppEnseignant()
//	{
//		enseignantService.delete(Long.valueOf(1013));
//		
//		assertThat(enseignantService.getById(Long.valueOf(1013))).isNull();
//	}
	
	//--------------- Promotion -------------------------
	@Test
	public void verfierDonneePromotions()
	{
		assertThat(promotionService.getAll()).isNotEmpty();
	}
	
	

}
