package com.isj.controllers;

import com.isj.models.*;
import com.isj.payload.EstInscritRequest;
import com.isj.services.CandidatService;
import com.isj.services.EnseignementService;
import com.isj.services.EstInscritService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api/isj/estInscrit")
@Controller
public class EstInscritController {
    @Autowired
    EstInscritService estInscritService;
    @Autowired
    private UtilisateurServices utilisateurServices;
    @Autowired
    private CandidatService candidatService;
    @Autowired
    private EnseignementService enseignementService;
    // la fonction recoit une request de Get, l'execute et renvoie la liste des EstInscrit
    @GetMapping
    public ResponseEntity<List<EstInscrit>> getAllEstIncrit(){
        List<EstInscrit> estInscrits= estInscritService.findEstInscrit();
        return new ResponseEntity<>(estInscrits, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer une nouvelle EstInscrit et le sauvegarde dans la BD
    @PostMapping("/save")
    public ResponseEntity<EstInscrit> saveEstInscrit(@RequestBody EstInscritRequest estInscritRequest){
        Utilisateur userCreateur= utilisateurServices.findById(estInscritRequest.getCreateurId()).get();
        Utilisateur userModificateur=utilisateurServices.findById(estInscritRequest.getModificateurId()).get();
        Candidat userCandidat = candidatService.findById(estInscritRequest.getCandidatId()).get();
        Enseignement userEnsengnement= enseignementService.findById(estInscritRequest.getEnseignementId()).get();

        java.sql.Date date= new java.sql.Date(System.currentTimeMillis());

        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();
        //try {
          //  Date dt = c.convertStringToDate(estInscritRequest.getDateNaissance());
            //date1 = new java.sql.Date(dt.getDate());

        //}catch (Exception e){

        //}
        EstInscrit estInscrit= new EstInscrit(estInscritRequest.getLibelle(),estInscritRequest.getDescription(),
                estInscritRequest.getStatut(), userCandidat,userEnsengnement);
        //signature
        estInscrit.setDateCreation(date);
        estInscrit.setDateModification(date);
        estInscrit.setStatutVie(Securite.StatutVie.ACTIVE);

        EstInscrit estInscrit1= estInscritService.insertEstInscrit(estInscrit);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("estInscrit","/api/isj/estInscrit" + estInscrit1.getCode().toString());
        return new ResponseEntity<>(estInscrit1,httpHeaders,HttpStatus.CREATED);
    }
    // la fonction recoit une requete, supprime estInscrit avec l'ID correspondant
    @DeleteMapping({"/ {id}"})
    public ResponseEntity <EstInscrit> deleteEstInscrit(@PathVariable("id") Long id){
        estInscritService.deleteEstIncrit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //fonction qui permet de mettre à jour les champs de l'objet estInscrit
    public ResponseEntity<EstInscrit> updateEstInscrit(@RequestBody EstInscrit estInscrit){
        estInscritService.updateEstInscrit(estInscrit);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("estInscrit","/api/isj/estInscrit" + estInscrit.getCode().toString());
        return new ResponseEntity<>(estInscrit,httpHeaders,HttpStatus.CREATED);
    }
}
