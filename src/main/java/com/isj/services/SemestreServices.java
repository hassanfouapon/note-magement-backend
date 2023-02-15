package com.isj.services;


import com.isj.models.Semestre;
import com.isj.repositories.SemestreRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SemestreServices {


    @Autowired
    private SemestreRepositorie semestreRepositorie;


    public Semestre insert(Semestre semestre){
        return  semestreRepositorie.save(semestre);
    }

    public Optional<Semestre> findById(long code){
        return semestreRepositorie.findById(code);
    }

    public List<Semestre> Findsemestre(){
        return  semestreRepositorie.findAll();
    }

    public void updatesemestre(Semestre semestre) {
        semestreRepositorie.save(semestre);
    }

    public void deletesemestre(long id){
        semestreRepositorie.deleteById(id);
    }
}
