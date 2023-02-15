package com.isj.services;

import com.isj.repositories.NiveauRepositorie;

import com.isj.models.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauServices {

    @Autowired
    private NiveauRepositorie niveauRepositorie;

    public Niveau insert(Niveau Niveau){
        return niveauRepositorie.save(Niveau);
    }


    public void save(Niveau Niveau){

        niveauRepositorie.save(Niveau);
    }

    public Optional<Niveau> findById(long code){
        return niveauRepositorie.findById(code);
    }

    public List<Niveau> findNiveau(){

        return niveauRepositorie.findAll();
    }

    public void deleteNiveau(long id){
        niveauRepositorie.deleteById(id);
    }

}
