package com.isj.controllers;

import com.isj.models.Classe;
import com.isj.models.Securite;
import com.isj.models.Utilisateur;
import com.isj.models.Candidat;
import com.isj.services.CandidatService;
import com.isj.payload.CandidatRequest;
import com.isj.services.ClassService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/isj/candidat")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private UtilisateurServices utilisateurServices;

    @Autowired
    private ClassService classService;
    // la fonction recoit une request de Get, l'execute et renvoie la liste des candidats

    @GetMapping
    public ResponseEntity<List<Candidat>> getAllCandidat(){
        List<Candidat> candidats = candidatService.FindCandidat();
        return  new ResponseEntity<>(candidats, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer un nouveau candidat et la sauvegarde dans la BD

    /**
    public ResponseEntity<Candidat> saveCandidat(@RequestBody Candidat candidat){
        Candidat candidat1 = candidatService.insert(candidat);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("candidat", "/api/isj/candidat" + candidat1.getCode().toString());
        return new ResponseEntity<>(candidat1, httpHeaders, HttpStatus.CREATED);
    }
     */

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Candidat> deleteCandidat(@PathVariable("id") Long id){
        candidatService.deleteCandidat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // la fonction recoit une request Post, créer un nouveau candidat et le sauvegarde dans la BD
    @PostMapping("/save")
    public ResponseEntity<Candidat> saveCandidat(@RequestBody CandidatRequest candidatRequest ){

        Utilisateur userCreateur = utilisateurServices.findById(candidatRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(candidatRequest.getModificateurId()).get();
        Classe classe = classService.findById(candidatRequest.getClasseId()).get();

        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();

        try {

            Date dt = c.convertStringToDate(candidatRequest.getDateNaissance());
            date1 = new java.sql.Date(dt.getDate());

        }catch (Exception e){

        }

        Candidat candidat = new Candidat(candidatRequest.getLibelle(),candidatRequest.getDescription(),candidatRequest.getNom(),candidatRequest.getPrenom(),
                candidatRequest.getEmail(),candidatRequest.getTelephone(),candidatRequest.getSexe(),candidatRequest.getStatut(),candidatRequest.getNomMere(),
                candidatRequest.getNomPere(),candidatRequest.getTelephoneMere(),candidatRequest.getTelephonePere(),candidatRequest.getProfessionPere(),
                candidatRequest.getProfessionMere(),candidatRequest.getRegionOrigine(),candidatRequest.getEcoleOrigine(),classe,candidatRequest.getLieuNaissance());
        candidat.setCreateur(userCreateur);
        candidat.setModificateur(userModificateur);
        //signature
        candidat.setDateCreation(date);
        candidat.setDateModification(date);
        candidat.setStatutVie(Securite.StatutVie.ACTIVE);
        Candidat candidat1 = candidatService.insert(candidat);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("candidat", "api/isj/candidat" + candidat1.getCode().toString());
        return new ResponseEntity<>(candidat1, httpHeaders, HttpStatus.CREATED);

    }

}
