package com.application.services.Impl;

import com.application.models.UniteEnseignement;
import com.application.repositories.UniteEnseignementRepository;
import com.application.services.UniteEnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteEnseignementImp implements UniteEnseignementService {

    @Autowired
    private final UniteEnseignementRepository uniteEnseignementRepository;

    public UniteEnseignementImp(UniteEnseignementRepository uniteEnseignementRepository) {
        this.uniteEnseignementRepository = uniteEnseignementRepository;
    }

    @Override
    public List<UniteEnseignement> getAll() {
        return uniteEnseignementRepository.findAll();
    }
}
