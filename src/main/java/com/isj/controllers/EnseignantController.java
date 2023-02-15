package com.isj.controllers;


import com.isj.models.Enseignant;
import com.isj.models.Securite;
import com.isj.models.Utilisateur;
import com.isj.payload.EnseignantRequest;
import com.isj.services.EnseignantService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/isj/enseignant")

// * cette classe permet de créer, lire, supprimer et mettre à jour un objet Enseignant dans la base de donnée

public class EnseignantController {
    @Autowired
    private EnseignantService enseignantService;
    @Autowired
    private UtilisateurServices utilisateurServices;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des enseignants

    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignant(){
        List<Enseignant> enseignants = enseignantService.FindEnseignant();
        return  new ResponseEntity<>(enseignants, HttpStatus.OK);
    }

    @GetMapping({"/{enseingnatId}"})
    public ResponseEntity<Enseignant> getEnseignant(@PathVariable Long enseingnatId) {
        return new ResponseEntity<>(enseignantService.findById(enseingnatId).get(), HttpStatus.OK);

    }
    // la fonction recoit une requete, supprime l'enseignant avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Enseignant> deleteEnseignant(@PathVariable("id") Long id){
        enseignantService.deleteEnseignant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   //fonction qui permet de mettre à jour les champs de l'objet Enseignant
    public ResponseEntity<Enseignant> updateEnseignant(@RequestBody Enseignant enseignant) {
        enseignantService.updateEnseignant(enseignant);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("enseignant", "/api/isj/enseignant" + enseignant.getCode().toString());
        return new ResponseEntity<>(enseignant, httpHeaders, HttpStatus.CREATED);

    }

    // la fonction recoit une request Post, créer un nouvel enseignant et le sauvegarde dans la BD
    @PostMapping("/save")
    public ResponseEntity<Enseignant> saveEnseignant(@RequestBody EnseignantRequest enseignantRequest ){
        Utilisateur userCreateur = utilisateurServices.findById(enseignantRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(enseignantRequest.getModificateurId()).get();

        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();
        try {
            Date dt = c.convertStringToDate(enseignantRequest.getDateNaissance());
            date1 = new java.sql.Date(dt.getDate());

        }catch (Exception e){

        }

        Enseignant enseignant = new Enseignant(enseignantRequest.getLibelle(),enseignantRequest.getDescription(),enseignantRequest.getNom(),enseignantRequest.getPrenom(),enseignantRequest.getEmail(),enseignantRequest.getTelephone(),date1,enseignantRequest.getSexe(),enseignantRequest.getStatut(),enseignantRequest.getQualification());
        enseignant.setCreateur(userCreateur);
        enseignant.setModificateur(userModificateur);
        //signature
        enseignant.setDateCreation(date);
        enseignant.setDateModification(date);
        enseignant.setStatutVie(Securite.StatutVie.ACTIVE);
        Enseignant enseignant1 = enseignantService.insert(enseignant);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("enseignant", "api/isj/enseignant" + enseignant1.getCode().toString());
        return new ResponseEntity<>(enseignant1, httpHeaders, HttpStatus.CREATED);

    }


}
