package com.isj.services;

import com.isj.models.TypeEvaluation;
import com.isj.repositories.TypeEvaluationRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeEvaluationService {
    @Autowired
    private TypeEvaluationRepositorie typeEvaluationRepositorie;
    public TypeEvaluation insertTypeEvaluation(TypeEvaluation typeEvaluation){
        return typeEvaluationRepositorie.save(typeEvaluation);
    }
    public List<TypeEvaluation> findTypeEvaluation(){
        return typeEvaluationRepositorie.findAll();
    }
    public  void deleteTypeEvaluation(long id){
        typeEvaluationRepositorie.deleteById(id);
    }
    public void updateTypeEluation(TypeEvaluation typeEvaluation){
        typeEvaluationRepositorie.save(typeEvaluation);
    }

    public Optional<TypeEvaluation> findById(long code){return typeEvaluationRepositorie.findById(code);}

}
