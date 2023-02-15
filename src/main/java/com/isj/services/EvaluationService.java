package com.isj.services;

import com.isj.models.Evaluation;
import com.isj.repositories.EtudiantRepositorie;
import com.isj.repositories.EvaluationRepositarie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    @Autowired
  private EvaluationRepositarie evaluationRepositarie;
    public Evaluation insertEvaluation(Evaluation evaluation){
        return evaluationRepositarie.save(evaluation);
    }
    public List<Evaluation> findEvaluation(){
        return evaluationRepositarie.findAll();
    }
    public void deleteEvaluation(long id){
        evaluationRepositarie.deleteById(id);
    }
    public void updateEvaluation(Evaluation evaluation){
        evaluationRepositarie.save(evaluation);
    }

    public Optional<Evaluation> findById(long code) {
        return evaluationRepositarie.findById(code);
    }


}
