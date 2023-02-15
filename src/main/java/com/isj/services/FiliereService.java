package com.isj.services;

import java.util.List;
import java.util.Optional;

import com.isj.models.Filiere;
import com.isj.repositories.FiliereRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepositorie filiereRepositorie;


    public Filiere insertFiliere(Filiere filiere){

       return filiereRepositorie.save(filiere);
    }
    public Optional<Filiere> findById(long code){
        return filiereRepositorie.findById(code);
    }
    public List<Filiere> findFiliere(){
        return filiereRepositorie.findAll();
    }
    public void deleteFiliere(long id){
        filiereRepositorie.deleteById(id);
    }
    public void updateFiliere(Filiere filiere) {
        filiereRepositorie.save(filiere);
    }


}
