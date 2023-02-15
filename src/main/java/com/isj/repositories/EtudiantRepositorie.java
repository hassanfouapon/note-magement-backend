package com.isj.repositories;

import com.isj.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepositorie extends JpaRepository<Etudiant, Long> {


}
