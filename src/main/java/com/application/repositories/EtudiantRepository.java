package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.models.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,String>{

}
