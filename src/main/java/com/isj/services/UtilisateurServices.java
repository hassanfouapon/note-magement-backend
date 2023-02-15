package com.isj.services;

import com.isj.models.Utilisateur;
import com.isj.repositories.UtilisateurRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class UtilisateurServices {

    @Autowired
    private UtilisateurRepositorie utilisateurRepositorie;


    public Optional<Utilisateur> findById(long code){
        return utilisateurRepositorie.findById(code);
    }




}
