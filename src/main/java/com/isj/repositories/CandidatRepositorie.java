package com.isj.repositories;

import com.isj.models.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepositorie extends  JpaRepository<Candidat, Long>{

}
