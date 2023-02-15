package com.isj.repositories;

import com.isj.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepositarie extends JpaRepository<Evaluation , Long> {

}
