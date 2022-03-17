package com.application.services.Impl;

import com.application.models.Formation;
import com.application.repositories.FormationRepository;
import com.application.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationServiceImp implements FormationService {

    @Autowired
    private final FormationRepository formationRepository;

    public FormationServiceImp(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    @Override
    public List<Formation> getAll() {
        return formationRepository.findAll();
    }
}
