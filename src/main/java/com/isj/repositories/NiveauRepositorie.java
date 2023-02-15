package com.isj.repositories;

import com.isj.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepositorie extends JpaRepository<Niveau, Long> {


}
