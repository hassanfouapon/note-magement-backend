package com.isj.services;

import com.isj.models.Candidat;
import com.isj.repositories.CandidatRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepositorie candidatRepositorie;


    public Candidat insert(Candidat candidat){
        return  candidatRepositorie.save(candidat);
    }

    public Optional<Candidat> findById(long code){
        return candidatRepositorie.findById(code);
    }

    public List<Candidat> FindCandidat(){
        return  candidatRepositorie.findAll();
    }

    public void updateCandidat(Candidat candidat) {
        candidatRepositorie.save(candidat);
    }

    public void deleteCandidat(long id){
        candidatRepositorie.deleteById(id);
    }


}
