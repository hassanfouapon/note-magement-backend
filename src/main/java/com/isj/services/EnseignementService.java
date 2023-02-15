package com.isj.services;

import com.isj.models.Enseignement;
import com.isj.repositories.EnseignementRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignementService {

    @Autowired
    private EnseignementRepositorie enseignementRepositorie;

    public Enseignement insert(Enseignement enseignement){
        return  enseignementRepositorie.save(enseignement);
    }

    public Optional<Enseignement> findById(long code){
        return enseignementRepositorie.findById(code);
    }

    public List<Enseignement> FindEnseignement(){
        return  enseignementRepositorie.findAll();
    }

    public void updateEnseignement(Enseignement enseignement) {
        enseignementRepositorie.save(enseignement);
    }

    public void deleteenseignement(long id){
        enseignementRepositorie.deleteById(id);
    }
}

