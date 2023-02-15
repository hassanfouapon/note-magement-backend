package com.isj.services;

import com.isj.models.Etudiant;
import com.isj.repositories.EtudiantRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepositorie etudiantRepositorie;

    public Etudiant insertEtudiant(Etudiant etudiant){
        return etudiantRepositorie.save(etudiant);
    }

    public List<Etudiant> findEtudiant(){
        return etudiantRepositorie.findAll();
    }

    public void deleteEtudiant(long id){
        etudiantRepositorie.deleteById(id);
    }

    public void updateEtudiant(Etudiant etudiant){
        etudiantRepositorie.save(etudiant);
    }
    public Optional<Etudiant> finById(long code){return etudiantRepositorie.findById(code );}


}
