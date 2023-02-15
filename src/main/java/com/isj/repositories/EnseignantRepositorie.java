package com.isj.repositories;

import com.isj.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepositorie extends JpaRepository<Enseignant, Long> {
}
