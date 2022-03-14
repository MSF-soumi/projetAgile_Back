package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.models.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle, String>{

}
