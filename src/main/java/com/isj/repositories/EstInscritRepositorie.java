package com.isj.repositories;

import com.isj.models.EstInscrit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstInscritRepositorie extends JpaRepository<EstInscrit, Long> {
}
