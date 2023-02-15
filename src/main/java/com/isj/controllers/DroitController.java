package com.isj.controllers;
import com.isj.models.Utilisateur;
import com.isj.payload.DroitRequest;
import com.isj.services.DroitService;
import com.isj.models.Securite;

import com.isj.models.Droit;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//cette classe permet de créer, lire, supprimer et mettre à jour un objet Droit dans la base de données

@RestController
@RequestMapping("api/isj/droit")
public class DroitController {
    @Autowired
    private DroitService droitService;
    @Autowired
    private UtilisateurServices utilisateurServices;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des droits

    @GetMapping
    public ResponseEntity<List<Droit>> getAllDroit(){
        List<Droit> droits = droitService.FindDroit();
        return  new ResponseEntity<>(droits, HttpStatus.OK);
    }

    // la fonction recoit une request Post, créer un nouveau droit et le sauvegarde dans la BD
    @PostMapping("/save")
    public ResponseEntity<Droit> saveDroit(@RequestBody DroitRequest droitRequest){
        Utilisateur userCreateur = utilisateurServices.findById(droitRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(droitRequest.getModificateurId()).get();

        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

        Droit droit = new Droit(droitRequest.getLibelle(),droitRequest.getDescription(),droitRequest.getCategorie(),droitRequest.isLecture(),droitRequest.isEcriture(),droitRequest.isModification(),droitRequest.isSuppression());
        droit.setCreateur(userCreateur);
        droit.setModificateur(userModificateur);

        droit.setDateCreation(date);
        droit.setDateModification(date);
        droit.setStatutVie(Securite.StatutVie.ACTIVE);

        Droit droit1 = droitService.insert(droit);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("droit", "api/isj/droit" + droit1.getCode().toString());
        return new ResponseEntity<>( httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping({"/{droitId}"})
    public ResponseEntity<Droit> getDroit(@PathVariable Long droitId) {
        return new ResponseEntity<>(droitService.findById(droitId).get(), HttpStatus.OK);

    }

    // la fonction recoit une requete, supprime une droit avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Droit> deleteDroit(@PathVariable("id") Long id){
        droitService.deleteDroit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //fonction qui permet de mettre à jour les champs de l'objet Droit
    public ResponseEntity<Droit> updateDroit(@RequestBody Droit droit) {
        droitService.updateDroit(droit);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("droit", "/api/isj/droit" + droit.getCode().toString());
        return new ResponseEntity<>(droit, httpHeaders, HttpStatus.CREATED);

    }
}
