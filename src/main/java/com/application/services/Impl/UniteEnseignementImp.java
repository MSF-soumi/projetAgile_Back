package com.application.services.Impl;

import com.application.exceptions.EntityNotFoundException;
import com.application.models.Enseignant;
import com.application.models.UniteEnseignement;
import com.application.repositories.EnseignantRepository;
import com.application.repositories.UniteEnseignementRepository;
import com.application.services.UniteEnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteEnseignementImp implements UniteEnseignementService {

    @Autowired
    private final UniteEnseignementRepository uniteEnseignementRepository;
    public final EnseignantRepository enseignantRepository;

    public UniteEnseignementImp(UniteEnseignementRepository uniteEnseignementRepository, EnseignantRepository enseignantRepository) {
        this.uniteEnseignementRepository = uniteEnseignementRepository;
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public List<UniteEnseignement> getAll() {
        return uniteEnseignementRepository.findAll();
    }

    @Override
    public List<UniteEnseignement> getUEByEnseignant(Long noEnseignant) {
        if (enseignantExists(noEnseignant))
        return uniteEnseignementRepository.findUniteEnseignementByEnseignant(enseignantRepository.getById(noEnseignant));
        else throw new EntityNotFoundException(Enseignant.class, "Numéro Enseignant", noEnseignant.toString());
    }

    public boolean enseignantExists(Long noEnseignant) throws EntityNotFoundException {
        return enseignantRepository.findById(noEnseignant).isPresent();
    }
}
