package com.isj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isj.models.Filiere;

@Repository
public interface FiliereRepositorie extends JpaRepository<Filiere, Long>{



}
