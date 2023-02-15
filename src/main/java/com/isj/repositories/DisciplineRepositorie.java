package com.isj.repositories;

import com.isj.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepositorie extends JpaRepository<Discipline, Long> {

}
