package com.application.repositories;

import com.application.models.TypeEnseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEnseignantRepository extends JpaRepository<TypeEnseignant,String> {

}
