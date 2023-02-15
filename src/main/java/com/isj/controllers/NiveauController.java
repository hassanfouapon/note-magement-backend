package com.isj.controllers;

import com.isj.models.Niveau;
import com.isj.models.Securite;
import com.isj.models.Utilisateur;
import com.isj.payload.NiveauRequest;
import com.isj.services.NiveauServices;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//cette classe permet de créer, lire, supprimer et mettre à jour un objet Niveau dans la base de données
@RestController
@RequestMapping("/api/isj/niveau")
public class NiveauController {
    @Autowired
    private NiveauServices niveauService;

    @Autowired private UtilisateurServices utilisateurServices;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des Niveaus

    @GetMapping
    public ResponseEntity<List<Niveau>> getAllNiveau(){
        List<Niveau> niveaux = niveauService.findNiveau();
        return  new ResponseEntity<>(niveaux, HttpStatus.OK);
    }

    // la fonction recoit une request Post, créer un nouveau Niveau et le sauvegarde dans la BD
    @PostMapping("/save")
    public ResponseEntity<Niveau> saveNiveau(@RequestBody NiveauRequest niveauRequest){

        Utilisateur userCreateur = utilisateurServices.findById(niveauRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(niveauRequest.getModificateurId()).get();

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());

        Niveau niveau = new Niveau(niveauRequest.getLibelle(),niveauRequest.getDescription(),niveauRequest.getNumero());
        niveau.setCreateur(userCreateur);
        niveau.setModificateur(userModificateur);
        niveau.setDateCreation(date);
        niveau.setDateModification(date);
        niveau.setStatutVie(Securite.StatutVie.ACTIVE);

        Niveau niveau1 = niveauService.insert(niveau);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Niveau", "/api/isj/niveau" + niveau1.getCode().toString());
        return new ResponseEntity<>(niveau1, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping({"/{NiveauId}"})
    public ResponseEntity<Niveau> getNiveau(@PathVariable Long NiveauId) {
        return new ResponseEntity<>(niveauService.findById(NiveauId).get(), HttpStatus.OK);
    }

    // la fonction recoit une requete, supprime une Niveau avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Niveau> deleteNiveau(@PathVariable("id") Long id){
        niveauService.deleteNiveau(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //fonction qui permet de mettre à jour les champs de l'objet Niveau
    @PostMapping("/update")
    public ResponseEntity<Niveau> updateNiveau(@RequestBody Niveau niveau) {
        niveauService.save(niveau);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Niveau", "/api/isj/Niveau" + niveau.getCode().toString());
        return new ResponseEntity<>(niveau, httpHeaders, HttpStatus.CREATED);
    }



}
