package com.isj.controllers;


import com.isj.models.Filiere;
import com.isj.models.Securite;
import com.isj.models.Specialite;
import com.isj.models.Utilisateur;
import com.isj.payload.SpecialiteRequest;
import com.isj.services.FiliereService;
import com.isj.services.SpecialiteService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// * cette classe permet de créer, lire, supprimer et mettre à jour un objet Specialite dans la base de donnée
@RequestMapping("/api/isj/specialisation")
@Controller
public class SpecialiteController {
    @Autowired
    private SpecialiteService specialiteService;
    @Autowired
    private UtilisateurServices utilisateurServices;
    @Autowired
    private FiliereService filiereService;


    // la fonction recoit une request de Get, l'execute et renvoie la liste des specialite

    @GetMapping
    public ResponseEntity<List<Specialite>> getAllSpecialite(){
        List<Specialite> specialites = specialiteService.FindSpecialite();
        return  new ResponseEntity<>(specialites, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer une nouvelle specialité et la sauvegarde dans la BD

    public ResponseEntity<Specialite> saveSpecialite(@RequestBody Specialite specialite){
        Specialite specialite1 = specialiteService.insert(specialite);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("specialite", "/api/isj/specialite" + specialite1.getCode().toString());
        return new ResponseEntity<>(specialite1, httpHeaders, HttpStatus.CREATED);
    }
    // la fonction recoit une requete, supprime la specialite avec l'ID correspondant

    @GetMapping({"/{specialiteId}"})
    public ResponseEntity<Specialite> getSpecialite(@PathVariable Long specialiteId) {
        return new ResponseEntity<>(specialiteService.findById(specialiteId).get(), HttpStatus.OK);

    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Specialite> deleteSpecialite(@PathVariable("id") Long id){
        specialiteService.deleteSpecialite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //fonction qui permet de mettre à jour les champs de l'objet specialite

    public ResponseEntity<Specialite> updateSpecialite(@RequestBody Specialite specialite) {
        specialiteService.updateSpecialite(specialite);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("specialite", "/api/isj/specialite" + specialite.getCode().toString());
        return new ResponseEntity<>(specialite, httpHeaders, HttpStatus.CREATED);

    }
    @PostMapping("/save")
    public ResponseEntity<Specialite> saveSpeciqlite(@RequestBody SpecialiteRequest specialiteRequest){
        Utilisateur userUtilisateur=utilisateurServices.findById(specialiteRequest.getCreateurId()).get();
        Utilisateur userModificateur= utilisateurServices.findById(specialiteRequest.getModificateurId()).get();
        Filiere filiere= filiereService.findById(specialiteRequest.getFiliereId()).get();
        java.sql.Date date= new java.sql.Date(System.currentTimeMillis());

        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();

        Specialite specialite= new Specialite(specialiteRequest.getLibelle(),specialiteRequest.getDescription(),
                filiere);

        //signature
        specialite.setDateCreation(date);
        specialite.setDateModification(date);
        specialite.setStatutVie(Securite.StatutVie.ACTIVE);


        Specialite specialite1= specialiteService.insert(specialite);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("specialite","/api/isj/specialite" + specialite1.getCode().toString());
        return new ResponseEntity<>(specialite1,httpHeaders,HttpStatus.CREATED);


    }

}
