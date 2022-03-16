package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.models.Sexe;


@Repository
public interface SexeRepository extends JpaRepository<Sexe,String>{

}
