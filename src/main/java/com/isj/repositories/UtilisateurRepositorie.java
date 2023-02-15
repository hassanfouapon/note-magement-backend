package com.isj.repositories;

import com.isj.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepositorie extends JpaRepository<Utilisateur, Long> {



}
