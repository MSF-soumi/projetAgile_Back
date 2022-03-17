package com.application.services.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import com.application.services.EnseignantService;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;

import org.apache.commons.validator.routines.EmailValidator;
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
				 ens.getNom(),
				 ens.getPrenom(), 
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
		return enseignantRepository.findAll();
	}
	
	@Override
	public Enseignant getById(Long id)
	{
		Optional<Enseignant> res = enseignantRepository.findById(id);
		return res.isPresent() ? res.get() : null;
	}
	
	@Override
	public Enseignant update(Enseignant enseignant) {
		Enseignant Enseignant=enseignantRepository.getById(enseignant.getNo_Enseignant());
		System.out.println("ID"+enseignant.getNo_Enseignant());
		Enseignant.setNom(enseignant.getNom());
		Enseignant.setPrenom(enseignant.getPrenom());
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
			throw new EnseignantSQLException(getClass(), id);
			
		}
		catch (Exception e)
		{
			System.out.println("Exception: "+e.toString());
			
		}
		return false;
		
	}
	
	@Override
	public Enseignant getByEmailUbo(String email_Ubo)
	{
		return enseignantRepository.findByEmail_Ubo(email_Ubo);
	}
  	
	@Override
	public Enseignant updateById(Long id, Enseignant enseignantRequest)
	{
		try 
		{
			if (differentId(id,enseignantRequest))
				{		
					Enseignant enseignantTrouve = enseignantRepository.findByEmail_Ubo(enseignantRequest.getEmail_Ubo());
			
					if(enseignantTrouve != null && 
							enseignantTrouve.getEmail_Ubo()!=null && 
							!enseignantTrouve.getNo_Enseignant().equals(enseignantRequest.getNo_Enseignant()))
						
							throw new EmailUboIsTakenException(Enseignant.class, enseignantRequest.getEmail_Ubo());
						
							return this.update(enseignantRequest);	
				}
			} catch (DifferentIdRequestException e) {
					e.printStackTrace();
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
