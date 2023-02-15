package com.isj.services;

import com.isj.models.Specialite;
import com.isj.repositories.SpecialiteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SpecialiteService {

    @Autowired
    private SpecialiteRepositorie specialiteRepositorie;


    public Specialite insert(Specialite specialite){
        return  specialiteRepositorie.save(specialite);
    }

    public Optional<Specialite> findById(long code){
        return specialiteRepositorie.findById(code);
    }

    public List<Specialite> FindSpecialite(){
        return  specialiteRepositorie.findAll();
    }

    public  Specialite updateSpecialite(Specialite specialite) {
        return  specialiteRepositorie.save(specialite);
    }

    public void deleteSpecialite(long id){
        specialiteRepositorie.deleteById(id);
    }
}
