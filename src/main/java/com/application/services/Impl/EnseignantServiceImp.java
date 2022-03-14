package com.application.services.Impl;

import java.util.List;
import java.util.Optional;

import com.application.services.EnseignantService;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.exceptions.enseignant.EmailPersoFormatException;
import com.application.exceptions.enseignant.EmailUboFormatException;
import com.application.exceptions.enseignant.EmailUboIsTakenException;
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
	public Enseignant create(Enseignant ens) throws EmailUboIsTakenException
	{
		
		if(enseignantRepository.findByEmail_Ubo(ens.getEmail_Ubo())!=null)
			throw new EmailUboIsTakenException(Enseignant.class, ens.getEmail_Ubo());
		
		try {
				if(validateEmailUboFormat(ens.getEmail_Ubo()) &&
					validateEmailPersoFormat(ens.getEmail_Perso()) &&
						phoneNumberFormat(ens.getMobile()) &&
							phoneNumberFormat(ens.getTelephone()))
				{
					Enseignant newEns=new Enseignant(ens.getNo_Enseignant() , ens.getNom(), ens.getPrenom(), ens.getSexe(), ens.getType(), ens.getPays(),
							ens.getVille(), ens.getAdresse(), ens.getEmail_Perso(), ens.getEmail_Ubo(), ens.getMobile(), ens.getTelephone(),
							ens.getCode_Postal());
					enseignantRepository.save(newEns);
					return newEns;
				}
			} catch (EmailUboFormatException e) {
				e.printStackTrace();
				System.out.println(e);
			} catch (EmailPersoFormatException e) {
				e.printStackTrace();
				System.out.println(e);
			} catch (PhoneNumberFormatException e) {
				e.printStackTrace();
				System.out.println(e);
			} catch (NumberParseException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		return null;
		
	}
	
	
	
	
//	@Override
//	public Enseignant create(Enseignant ens)
//	{
//		Enseignant newEns=new Enseignant(ens.getNo_Enseignant() , ens.getNom(), ens.getPrenom(), ens.getSexe(), ens.getType(), ens.getPays(),
//				ens.getVille(), ens.getAdresse(), ens.getEmail_Perso(), ens.getEmail_Ubo(), ens.getMobile(), ens.getTelephone(),
//				ens.getCode_Postal());
//		enseignantRepository.save(newEns);
//		return newEns;
//	}
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
		try{
			enseignantRepository.deleteById(id);
			System.out.println("delete passed ");
			return true;
		}catch (Exception e){
			System.out.println("Exception "+e.getMessage());
			return false;
		}
	}
	@Override
	public Enseignant getByEmailUbo(String email_Ubo)
	{
		return enseignantRepository.findByEmail_Ubo(email_Ubo);
	}
  
	@Override
	public Enseignant updateById(Long id, Enseignant enseignantRequest)
	{
		if(this.getById(id) !=null && id.equals(enseignantRequest.getNo_Enseignant())) {
			System.out.println("ana hnaya");
			return this.update(enseignantRequest);
		}
		return null;
		
	}

	public boolean validateEmailUboFormat(String email) throws EmailUboFormatException {
		if( !email.endsWith("@univ-brest.fr"))
			throw new EmailPersoFormatException(Enseignant.class, email);
		else return true;
	}
	
	public boolean validateEmailPersoFormat(String email) throws EmailPersoFormatException {
		EmailValidator validator = EmailValidator.getInstance();
		System.out.println("validator : "+!validator.isValid(email));
		if(!validator.isValid(email))
			throw new EmailPersoFormatException(Enseignant.class, email);
		else return true;
		
	}
	
	public boolean phoneNumberFormat(String tel) throws PhoneNumberFormatException, NumberParseException {
		System.out.println("parse :" + phoneNumberUtil.parse(tel, 
			      CountryCodeSource.UNSPECIFIED.name()));
		if(!phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(tel, 
			      CountryCodeSource.UNSPECIFIED.name())))
			throw new PhoneNumberFormatException(Enseignant.class, tel);
		else return true;
			
	}
}
