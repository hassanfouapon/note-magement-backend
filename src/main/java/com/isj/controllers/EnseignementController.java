package com.isj.controllers;

import com.isj.models.*;
import com.isj.payload.EnseignementRequest;
import com.isj.services.EnseignementService;
import com.isj.services.SemestreServices;
import com.isj.services.UeService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isj/enseignement")
public class EnseignementController {

    @Autowired
    private EnseignementService enseignementService;
    @Autowired
    private SemestreServices semestreServices;
    @Autowired
    private UeService ueService;

    @Autowired
    private UtilisateurServices utilisateurServices;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des Enseignement

    @GetMapping
    public ResponseEntity<List<Enseignement>> getAllEnseignement(){
        List<Enseignement> enseignements = enseignementService.FindEnseignement();
        return  new ResponseEntity<>(enseignements, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer un nouvel enseignant et le sauvegarde dans la BD



    @PostMapping("/save")
    public ResponseEntity<Enseignement> saveEnseignement(@RequestBody EnseignementRequest enseignementRequest){

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        Utilisateur userCreateur = utilisateurServices.findById(enseignementRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(enseignementRequest.getModificateurId()).get();


        Semestre semestre = semestreServices.findById(enseignementRequest.getCodesemestre()).get();
        UE ue= ueService.findById(enseignementRequest.getCodeue()).get();


        Enseignement enseignement = new Enseignement(enseignementRequest.getLibelle(),enseignementRequest.getDescription(),enseignementRequest.getHeuresDeCours(),enseignementRequest.getProgrammeDeCours(),semestre,ue,enseignementRequest.getCredit());


        enseignement.setStatutVie(Securite.StatutVie.ACTIVE);
        enseignement.setDateCreation(date);
        enseignement.setDateModification(date);
        enseignement.setModificateur(userModificateur);
        enseignement.setCreateur(userCreateur);
        enseignement.getHeuresDeCours();
        enseignement.getProgrammeDeCours();
        enseignement.getSemestre();
        enseignement.getUe();
        enseignement.getCredit();

        Enseignement enseignement1 = enseignementService.insert(enseignement);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("classe", "/api/isj/classe" + enseignement1.getCode().toString());
        return new ResponseEntity<>(enseignement1, httpHeaders, HttpStatus.CREATED);
    }


    // la fonction recoit une requete, supprime l'Enseignement avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Enseignement> deleteEnseignement(@PathVariable("id") Long id){
        enseignementService.deleteenseignement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Enseignement> updateEnseignement(@RequestBody Enseignement enseignement) {
        enseignementService.updateEnseignement(enseignement);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("enseignement", "/api/isj/Enseignement" + enseignement.getCode().toString());
        return new ResponseEntity<>(enseignement, httpHeaders, HttpStatus.CREATED);
    }




}
