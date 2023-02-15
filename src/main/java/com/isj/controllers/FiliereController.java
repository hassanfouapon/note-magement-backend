package com.isj.controllers;

import java.util.List;

import com.isj.models.Filiere;
import com.isj.models.Securite;
import com.isj.models.Utilisateur;
import com.isj.payload.FiliereRequest;
import com.isj.services.FiliereService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// * cette classe permet de créer, lire, supprimer et mettre à jour un objet Filiere dans la base de donnée



@RequestMapping("/api/isj/filiere")
@RestController
public class FiliereController {

    @Autowired
    private FiliereService filiereService;
    @Autowired private UtilisateurServices utilisateurServices;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des filieres

    @GetMapping
    public ResponseEntity<List<Filiere>> getAllFiliere(){
        List<Filiere> filieres = filiereService.findFiliere();
        return  new ResponseEntity<>(filieres, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer une nouvelle filiere et le sauvegarde dans la BD

    @PostMapping("/save")
    public ResponseEntity<Filiere> saveFiliere(@RequestBody FiliereRequest filiereRequest){

        Utilisateur userCreateur = utilisateurServices.findById(filiereRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(filiereRequest.getModificateurId()).get();

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());

        Filiere filiere = new Filiere(filiereRequest.getLibelle(),filiereRequest.getDescription());

        filiere.setCreateur(userCreateur);
        filiere.setModificateur(userModificateur);
        filiere.setDateCreation(date);
        filiere.setDateModification(date);
        filiere.setStatutVie(Securite.StatutVie.ACTIVE);
        
        Filiere filiere1 = filiereService.insertFiliere(filiere);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("filiere", "/api/isj/filiere" + filiere1.getCode().toString());
        return new ResponseEntity<>(filiere1, httpHeaders, HttpStatus.CREATED);
    }


    @GetMapping({"/{filiereId}"})
    public ResponseEntity<Filiere> getFiliere(@PathVariable Long filiereId) {
        return new ResponseEntity<>(filiereService.findById(filiereId).get(), HttpStatus.OK);

    }


    // la fonction recoit une requete, supprime la filiere avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Filiere> deleteFiliere(@PathVariable("id") Long id){
        filiereService.deleteFiliere(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //fonction qui permet de mettre à jour les champs de l'objet filiere
    public ResponseEntity<Filiere> updateFiliere(@RequestBody Filiere filiere) {
        filiereService.updateFiliere(filiere);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("filiere", "/api/isj/filiere" + filiere.getCode().toString());
        return new ResponseEntity<>(filiere, httpHeaders, HttpStatus.CREATED);

    }




}
