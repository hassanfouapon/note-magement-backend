package com.isj.services;

import com.isj.models.EstInscrit;
import com.isj.repositories.EstInscritRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstInscritService {
    @Autowired
    private EstInscritRepositorie estInscritRepositorie;
    public EstInscrit insertEstInscrit(EstInscrit estInscrit){
        return estInscritRepositorie.save(estInscrit);
    }
    public List<EstInscrit> findEstInscrit(){
        return estInscritRepositorie.findAll();
    }
    public void deleteEstIncrit(long id){
        estInscritRepositorie.deleteById(id);
    }
    public void updateEstInscrit(EstInscrit estInscrit){
        estInscritRepositorie.save(estInscrit);
    }
    public Optional<EstInscrit> finById(long code){return estInscritRepositorie.findById(code);}
}
