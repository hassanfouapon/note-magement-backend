package com.isj.controllers;

import com.isj.models.Classe;
import com.isj.models.Etudiant;
import com.isj.models.Securite;
import com.isj.models.Utilisateur;
import com.isj.payload.EtudiantRequest;
import com.isj.services.ClassService;
import com.isj.services.EtudiantService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/api/isj/etudiant")
@RestController
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    private UtilisateurServices utilisateurServices;
    @Autowired
    private ClassService classService;
    // la fonction recoit une request de Get, l'execute et renvoie la liste des filieres

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiant(){
        List<Etudiant> etudiants= etudiantService.findEtudiant();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    // la fonction recoit une request Post, créer un nouveau etudiant et le sauvegarde dans la BD
    @PostMapping("/save")
    public ResponseEntity<Etudiant> saveEtudiant(@RequestBody EtudiantRequest etudiantRequest){
        Utilisateur userCreateur= utilisateurServices.findById(etudiantRequest.getCreateurId()).get();
        Classe classe= classService.findById(etudiantRequest.getClasseId()).get();
        Utilisateur userModificateur=utilisateurServices.findById(etudiantRequest.getModificateurId()).get();
        java.sql.Date date= new java.sql.Date(System.currentTimeMillis());

        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();
        try {
            Date dt = c.convertStringToDate(etudiantRequest.getDateNaissance());
            date1 = new java.sql.Date(dt.getDate());

        }catch (Exception e){

        }


        Etudiant etudiant= new Etudiant(etudiantRequest.getLibelle(),etudiantRequest.getDescription(),etudiantRequest.getNom(),
                etudiantRequest.getPrenom(),etudiantRequest.getEmail(),etudiantRequest.getTelephone(),date1,
                etudiantRequest.getSexe(),etudiantRequest.getStatut(),etudiantRequest.getNomDeLaMere(),etudiantRequest.getNomDuPere(),
                etudiantRequest.getTelephoneDeLaMere(),etudiantRequest.getTelephoneDuPere(),etudiantRequest.getProfessionDuPere(),etudiantRequest.getProfessionDelaMere(),
                etudiantRequest.getRegionOrigine(), etudiantRequest.getEcoleOrigine(),classe,etudiantRequest.getMatricule(),etudiantRequest.getCodeAuthentification(),
                etudiantRequest.getLieuNaissance());
        etudiant.setCreateur(userCreateur);
        etudiant.setModificateur(userModificateur);
        //signature
        etudiant.setDateCreation(date);
        etudiant.setDateModification(date);
        etudiant.setStatutVie(Securite.StatutVie.ACTIVE);

        Etudiant etudiant1= etudiantService.insertEtudiant(etudiant);

        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("etudiant", "/api/isj/etudiant");
        return new ResponseEntity<>(etudiant1,httpHeaders,HttpStatus.CREATED);
    }


    // la fonction recoit une requete, supprime l'étudiant avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity <Etudiant> deleteEtudiant(@PathVariable("id") Long id){
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    //fonction qui permet de mettre à jour les champs de l'objet etudiant

    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
        etudiantService.updateEtudiant(etudiant);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("etudiant","/api/isj/etudiant" + etudiant.getCode().toString());
        return new ResponseEntity<>(etudiant,httpHeaders, HttpStatus.CREATED);

    }
}
