package com.application.services.Impl;

import com.application.models.TypeEnseignant;
import com.application.repositories.TypeEnseignantRepository;
import com.application.services.TypeEnseignantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEnseignantServiceImp implements TypeEnseignantService {

    private final TypeEnseignantRepository typeEnseignantRepository;

    public TypeEnseignantServiceImp(TypeEnseignantRepository typeEnseignantRepository) {
        this.typeEnseignantRepository = typeEnseignantRepository;
    }

    @Override
    public List<TypeEnseignant> getAll() {
        return typeEnseignantRepository.findAll();
    }
}
