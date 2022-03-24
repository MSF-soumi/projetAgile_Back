package com.application.services.Impl;

import java.util.List;
import java.util.Optional;

import com.application.exceptions.EntityNotFoundException;
import com.application.exceptions.etudiant.DifferentIdRequestException;
import com.application.exceptions.enseignant.EmailUboIsTakenException;
import com.application.exceptions.enseignant.EnseignantNotFoundException;
import com.application.exceptions.enseignant.PhoneNumberFormatException;
import com.application.exceptions.etudiant.EtudiantSQLException;
import com.application.exceptions.etudiant.EtudiantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.application.models.Enseignant;
import com.application.models.Etudiant;
import com.application.repositories.EtudiantRepository;
import com.application.services.EtudiantService;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;

@Service
public class EtudiantServiceImp implements EtudiantService{
	
	@Autowired
	private final EtudiantRepository etudiantRepository;
	
	PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
	
	public EtudiantServiceImp(EtudiantRepository etudiantRepo) {
		etudiantRepository=etudiantRepo;
	}

	@Override
	public List<Etudiant> getAll() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant getById(String id) {
		// TODO Auto-generated method stub
		Optional<Etudiant> res = etudiantRepository.findById(id);
		return res.isPresent() ? res.get() : null;

	}

	@Override
	public List<Etudiant> findByPromo(String code_Formation, String annee_Universitaire) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByPromo(code_Formation, annee_Universitaire);
	}
	
	
	public Etudiant update(Etudiant etudiant) {
		Etudiant Etudiant = etudiantRepository.getById(etudiant.getNo_Etudiant());
		Etudiant.setCode_Formation(etudiant.getCode_Formation());
		Etudiant.setAnnee_Universitaire(etudiant.getAnnee_Universitaire());
		Etudiant.setNom(etudiant.getNom().toUpperCase());
		Etudiant.setPrenom(etudiant.getPrenom().substring(0,1) + etudiant.getPrenom().substring(1));
		Etudiant.setSexe(etudiant.getSexe());
		Etudiant.setDate_Naissance(etudiant.getDate_Naissance());
		Etudiant.setLieu_Naissance(etudiant.getLieu_Naissance());
		Etudiant.setNationalite(etudiant.getNationalite());
		Etudiant.setTelephone(etudiant.getTelephone());
		Etudiant.setMobile(etudiant.getMobile());
		Etudiant.setEmail(etudiant.getEmail());
		Etudiant.setEmail_Ubo(etudiant.getEmail_Ubo());
		Etudiant.setAdresse(etudiant.getAdresse());
		Etudiant.setCode_Postal(etudiant.getCode_Postal());
		Etudiant.setVille(etudiant.getVille());
		Etudiant.setPays_Origine(etudiant.getPays_Origine());
		Etudiant.setUniversite_origine(etudiant.getUniversite_origine());
		Etudiant.setGroupe_Tp(etudiant.getGroupe_Tp());
		Etudiant.setGroupe_Anglais(etudiant.getGroupe_Anglais());
		return etudiantRepository.save(Etudiant);
	}
	
	
	public Etudiant updateById(String id, Etudiant etudiantRequest) {
		try {
			if(differentId(id.toString(),etudiantRequest)) {
				if(etudiantRequest.getEmail_Ubo() != null) {
					Etudiant etudiantTrouve = etudiantRepository.findByEmail_Ubo(etudiantRequest.getEmail_Ubo());
					if(etudiantTrouve !=null && etudiantTrouve.getEmail_Ubo() !=null && !etudiantTrouve.getNo_Etudiant().equals(etudiantRequest.getNo_Etudiant()))			
						throw new EmailUboIsTakenException(Etudiant.class, etudiantRequest.getEmail_Ubo());
					
				}
				if(etudiantRequest.getMobile()!=null && etudiantRequest.getMobile()!="" && phoneNumberFormat(etudiantRequest.getMobile()) )
					throw new PhoneNumberFormatException(Etudiant.class, etudiantRequest.getMobile());
			
					if( etudiantRequest.getTelephone()!=null && etudiantRequest.getTelephone()!="" && phoneNumberFormat(etudiantRequest.getTelephone()))
					throw new PhoneNumberFormatException(Etudiant.class, etudiantRequest.getTelephone());
			
					
					return this.update(etudiantRequest);
					
			}
		}catch (DifferentIdRequestException e) {
			e.printStackTrace();
	}

			return null;
	}
	
public boolean differentId(String id,Etudiant etudiantRequest){
		
		if(this.getById(id) == null){
			
			throw new EtudiantNotFoundException(Etudiant.class, id);
		}
		else {
			
			if(!id.toString().equals(etudiantRequest.getNo_Etudiant().toString()))
				throw new DifferentIdRequestException(Etudiant.class,id);
			else return true;
		}
		
	}


public boolean phoneNumberFormat(String tel) throws PhoneNumberFormatException {
	
	try {
		if(!phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(tel, 
			      CountryCodeSource.UNSPECIFIED.name())))
		return true;
	} catch (NumberParseException e) {
		throw new PhoneNumberFormatException(Etudiant.class, tel);
	}
	return false;
	
}


	
	public boolean deleteById(String id){
		if(!etudiantRepository.existsById(id)){
			throw new EtudiantNotFoundException(Etudiant.class, id);
		}
		else{
			try{
				etudiantRepository.deleteById(id);
				return true;
			}catch(DataIntegrityViolationException e){
				throw new EtudiantSQLException(EtudiantSQLException.class, id);
			}
		}
	}

}
