package com.isj.services;

import com.isj.models.Anonymat;
import com.isj.repositories.AnonymatRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnonymatService {
    @Autowired
    private AnonymatRepositorie anonymatRepositorie;


    public Anonymat insert(Anonymat anonymat){
        return  anonymatRepositorie.save(anonymat);
    }

    public Optional<Anonymat> findById(long code){
        return anonymatRepositorie.findById(code);
    }

    public List<Anonymat> FindAnonymat(){
        return  anonymatRepositorie.findAll();
    }

    public void updateAnonymat(Anonymat anonymat) {
        anonymatRepositorie.save(anonymat);
    }

    public void deleteAnonymat(long id){
        anonymatRepositorie.deleteById(id);
    }


}
