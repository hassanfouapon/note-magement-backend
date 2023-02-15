package com.isj.controllers;

import com.isj.models.AnneeAcademique;
import com.isj.models.Securite;
import com.isj.models.Semestre;
import com.isj.models.Utilisateur;
import com.isj.payload.SemestreRequest;
import com.isj.services.AnneAcademiqueService;
import com.isj.services.SemestreServices;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/isj/Semestre")

public class Semestrecontroller {

    @Autowired
    private SemestreServices semestreServices;
    @Autowired
    private UtilisateurServices utilisateurServices;

    @Autowired private AnneAcademiqueService anneAcademiqueService;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des semestre

    @GetMapping
    public ResponseEntity<List<Semestre>> getAllSemestre(){
        List<Semestre> semestre = semestreServices.Findsemestre();
        return  new ResponseEntity<>(semestre, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer un nouvel Semestre et le sauvegarde dans la BD

    public ResponseEntity<Semestre> saveSemestre(@RequestBody Semestre semestre1){
        Semestre Semestre1 = semestreServices.insert(semestre1);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("semestre", "/api/isj/semestre" + semestre1.getCode().toString());
        return new ResponseEntity<>(semestre1, httpHeaders, HttpStatus.CREATED);
    }


    @PostMapping("/save")
    public ResponseEntity<Semestre> saveSemestre(@RequestBody SemestreRequest semestreRequest){

        Utilisateur userCreateur = utilisateurServices.findById(semestreRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(semestreRequest.getModificateurId()).get();
        AnneeAcademique anneeAcademique = anneAcademiqueService.findById(semestreRequest.getAnne_academique()).get();


        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        java.sql.Date date_cloture = new java.sql.Date(System.currentTimeMillis());
        java.sql.Date date_debut = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();

        try {
            Date dt_debut = c.convertStringToDate(semestreRequest.getDate_debut());
            Date dt_cloture = c.convertStringToDate(semestreRequest.getDate_cloture());


            date_cloture = new java.sql.Date(dt_cloture.getDate());
            date_debut = new java.sql.Date(dt_debut.getDate());


        }catch (Exception e){

        }

        Semestre semestre = new Semestre(semestreRequest.getLibelle(),semestreRequest.getDescription(),date_debut,date_cloture,anneeAcademique);

        semestre.setCreateur(userCreateur);
        semestre.setModificateur(userModificateur);
        //la signature

        semestre.setStatutVie(Securite.StatutVie.ACTIVE);
        semestre.setDateCreation(date_cloture);
        semestre.setDateModification(date_debut);
        semestre.getAnneeAcademique();


        Semestre semestre1= semestreServices.insert(semestre);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("semestre", "/api/isj/semestre" + semestre1.getCode().toString());
        return new ResponseEntity<>(semestre1, httpHeaders, HttpStatus.CREATED);
    }






    // la fonction recoit une requete, supprime le semestre avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Semestre> deleteSemestre(@PathVariable("id") Long id){
        semestreServices.deletesemestre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Semestre> updateEnseignant(@RequestBody Semestre semestre) {
        semestreServices.updatesemestre(semestre);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("semestre", "/api/isj/semestre" + semestre.getCode().toString());
        return new ResponseEntity<>(semestre, httpHeaders, HttpStatus.CREATED);

    }


}
