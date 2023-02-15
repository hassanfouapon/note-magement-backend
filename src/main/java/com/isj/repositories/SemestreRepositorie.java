package com.isj.repositories;

import com.isj.models.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepositorie extends JpaRepository<Semestre, Long> {
}
