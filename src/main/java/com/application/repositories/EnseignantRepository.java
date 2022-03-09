package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.models.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {

}
