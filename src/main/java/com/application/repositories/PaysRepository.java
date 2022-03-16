package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.models.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays,String>{

}
