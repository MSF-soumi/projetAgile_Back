package com.application.services.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.application.exceptions.EntityNotFoundException;
import com.application.models.Promotion;
import com.application.models.UniteEnseignement;
import com.application.models.UniteEnseignementPK;
import com.application.services.EnseignantService;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.application.exceptions.enseignant.DifferentIdRequestException;
import com.application.exceptions.enseignant.EmailUboIsTakenException;
import com.application.exceptions.enseignant.EnseignantNotFoundException;
import com.application.exceptions.enseignant.EnseignantSQLException;

import com.application.exceptions.enseignant.PhoneNumberFormatException;

import com.application.models.Enseignant;
import com.application.repositories.EnseignantRepository;


@Service
public class EnseignantServiceImp implements EnseignantService {

	PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
	
	@Autowired
	private final EnseignantRepository enseignantRepository ;
		
	public EnseignantServiceImp(EnseignantRepository enseignantRepo) {
		enseignantRepository=enseignantRepo;
	}
	
	@Override
	public Enseignant create(Enseignant ens) 
	{
		
		if(enseignantRepository.findByEmail_Ubo(ens.getEmail_Ubo())!=null)
			throw new EmailUboIsTakenException(Enseignant.class, ens.getEmail_Ubo());
		
		if(phoneNumberFormat(ens.getMobile()) )
			throw new PhoneNumberFormatException(Enseignant.class, ens.getMobile());
		
		if( phoneNumberFormat(ens.getTelephone()))
			throw new PhoneNumberFormatException(Enseignant.class, ens.getTelephone());


		Enseignant newEns=new Enseignant(ens.getNo_Enseignant() ,
				 ens.getNom().toUpperCase(),
				 ens.getPrenom().substring(0,1).toUpperCase() + ens.getPrenom().substring(1),
				 ens.getSexe(), 
				 ens.getType(), 
				 ens.getPays(),
				 ens.getVille(), 
				 ens.getAdresse(), 
				 ens.getEmail_Perso(), 
				 ens.getEmail_Ubo(), 
				 ens.getMobile(), 
				 ens.getTelephone(),
				 ens.getCode_Postal());
		enseignantRepository.save(newEns);
		
		return newEns;
		
	}
	
	@Override
	public List<Enseignant> getAll()
	{
		List<Enseignant> enseignants = new ArrayList<Enseignant>();
		enseignants = enseignantRepository.findAll();
		for(Enseignant enseignant : enseignants){
			calculerEtd(enseignant);
		}
		Collections.sort(enseignants);
		return enseignants;
	}

	@Override
	public Enseignant getById(Long id) {
		if(enseignantRepository.existsById(id)){
			Enseignant enseignant = enseignantRepository.findById(id).orElseThrow(() -> new EnseignantNotFoundException(Enseignant.class, id));
			return calculerEtd(enseignant);
		}
		else throw new EnseignantNotFoundException(Enseignant.class, id);
	}
	
	@Override
	public Enseignant update(Enseignant enseignant) {
		Enseignant Enseignant=enseignantRepository.getById(enseignant.getNo_Enseignant());
		Enseignant.setNom(enseignant.getNom().toUpperCase());
		Enseignant.setPrenom(enseignant.getPrenom().substring(0,1).toUpperCase() + enseignant.getPrenom().substring(1));
		Enseignant.setSexe(enseignant.getSexe());
		Enseignant.setType(enseignant.getType());
		Enseignant.setPays(enseignant.getPays());
		Enseignant.setVille(enseignant.getVille());
		Enseignant.setAdresse(enseignant.getAdresse());
		Enseignant.setEmail_Perso(enseignant.getEmail_Perso());
	//	Enseignant.setEmailUbo(enseignant.getEmailUbo()); *non modifiable
		Enseignant.setMobile(enseignant.getMobile());
		Enseignant.setTelephone(enseignant.getTelephone());
		Enseignant.setCode_Postal(enseignant.getCode_Postal());
		return enseignantRepository.save(Enseignant);
	}
	
	@Override
	public boolean delete(Long id)
	{
		try 
		{
			getById(id);
			enseignantRepository.deleteById(id);
			return true;

		} 
		catch (EnseignantNotFoundException e)
		{
			System.out.println("EnseignantNotFoundException: "+e.getMessage());
			
		}	
		catch (DataIntegrityViolationException e)
		{
			System.out.println("SQLException: "+e.getMessage());
			throw new EnseignantSQLException(Enseignant.class, id);
			
		}
		catch (Exception e)
		{
			System.out.println("Exception: "+e.toString());
			
		}
		return false;
		
	}

	@Override
	public Enseignant calculerEtd(Enseignant enseignant){
		if(!enseignantRepository.existsById(enseignant.getNo_Enseignant())){
			throw new EnseignantNotFoundException(Enseignant.class, enseignant.getNo_Enseignant());
		}
		else{
			Integer nbh_cm =0;
			Integer nbh_td =0;
			Integer nbh_tp =0;
			Double nbh_etd =0.00;
			for(UniteEnseignement uniteEnseignement : enseignant.getUniteEnseignementSet() ){
				nbh_cm += uniteEnseignement.getNbh_cm();
				nbh_td += uniteEnseignement.getNbh_td();
				nbh_tp += uniteEnseignement.getNbh_tp();
				nbh_etd += uniteEnseignement.getNbh_etd();
			}
			enseignant.setNbh_cm(nbh_cm);
			enseignant.setNbh_td(nbh_td);
			enseignant.setNbh_tp(nbh_tp);
			enseignant.setNbh_etd(nbh_etd);
		}
		return enseignant;
	}

	@Override
	public Double sumEtd(Long id){
		var uniteEnseignements = enseignantRepository.getById(id).getUniteEnseignementSet();
		Double sumEtd = 0.00;
		for(UniteEnseignement uniteEnseignement: uniteEnseignements){
			sumEtd += uniteEnseignement.getNbhEtd();
		}
		return sumEtd;
	}


	/*public void deleteEnseignant(Long id) throws SQLException
	{
		enseignantRepository.deleteById(id);

	}*/
	
	@Override
	public Enseignant getByEmailUbo(String email_Ubo)
	{
		return enseignantRepository.findByEmail_Ubo(email_Ubo);
	}


	@Override
	public Enseignant updateById(Long id, Enseignant enseignantRequest)
	{
			if (differentId(id,enseignantRequest))
				{		
					Enseignant enseignantTrouve = enseignantRepository.findByEmail_Ubo(enseignantRequest.getEmail_Ubo());
			
					if(enseignantTrouve != null && 
							enseignantTrouve.getEmail_Ubo()!=null && 
							!enseignantTrouve.getNo_Enseignant().equals(enseignantRequest.getNo_Enseignant()))

							throw new EmailUboIsTakenException(Enseignant.class, enseignantRequest.getEmail_Ubo());
							
							if(phoneNumberFormat(enseignantRequest.getMobile()) )
							throw new PhoneNumberFormatException(Enseignant.class, enseignantRequest.getMobile());
					
							if( phoneNumberFormat(enseignantRequest.getTelephone()))
							throw new PhoneNumberFormatException(Enseignant.class, enseignantRequest.getTelephone());
					
							return this.update(enseignantRequest);
				}
	
		return null;
		
	}
	
	public boolean differentId(Long id,Enseignant enseignantRequest){
		
		if(this.getById(id) == null){
			
			throw new EnseignantNotFoundException(Enseignant.class, id);
		}
		else {
			
			if(!id.equals(enseignantRequest.getNo_Enseignant()))
				throw new DifferentIdRequestException(Enseignant.class, id);
			else return true;
		}
		
	}
	
	public boolean phoneNumberFormat(String tel) throws PhoneNumberFormatException {
		try {
			if(!phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(tel, 
				      CountryCodeSource.UNSPECIFIED.name())))
			return true;
		} catch (NumberParseException e) {
			throw new PhoneNumberFormatException(Enseignant.class, tel);
		}
		return false;
		
	}


}
