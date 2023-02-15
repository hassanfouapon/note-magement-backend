package com.isj.repositories;

import com.isj.models.Droit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroitRepositorie extends JpaRepository<Droit, Long> {
}
