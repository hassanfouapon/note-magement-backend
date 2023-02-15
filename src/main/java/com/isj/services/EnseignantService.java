package com.isj.services;

import com.isj.models.Enseignant;
import com.isj.repositories.EnseignantRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepositorie enseignantRepositorie;


    public Enseignant insert(Enseignant enseignant){
        return  enseignantRepositorie.save(enseignant);
    }

    public Optional<Enseignant> findById(long code){
        return enseignantRepositorie.findById(code);
    }

    public List<Enseignant> FindEnseignant(){
        return  enseignantRepositorie.findAll();
    }

    public void updateEnseignant(Enseignant enseignant) {
        enseignantRepositorie.save(enseignant);
    }

    public void deleteEnseignant(long id){

        enseignantRepositorie.deleteById(id);
    }




}
