package com.isj.controllers;
import com.isj.models.UE;
import com.isj.services.UeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isj/uniteEnseignement")

//cette classe permet de créer, lire, supprimer et mettre à jour un objet UE dans la base de données

public class UeController {
    @Autowired
    private UeService ueService;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des enseignants

    @GetMapping
    public ResponseEntity<List<UE>> getAllUe(){
        List<UE> ue = ueService.findUe();
        return  new ResponseEntity<>(ue, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer une nouvelle UE et le sauvegarde dans la BD

    public ResponseEntity<UE> saveUe(@RequestBody UE ue){
        UE ue1 = ueService.insertUe(ue);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("uniteEnseignement", "/api/isj/uniteEnseignement" + ue1.getCode().toString());
        return new ResponseEntity<>(ue1, httpHeaders, HttpStatus.CREATED);
    }
    // la fonction recoit une requete, supprime l'enseignant avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<UE> deleteEnseignant(@PathVariable("id") Long id){
        ueService.deleteUe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //fonction qui permet de mettre à jour les champs de l'objet UE
    public ResponseEntity<UE> updateUe(@RequestBody UE ue) {
        ueService.updateUe(ue);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("ue", "/api/isj/ue" + ue.getCode().toString());
        return new ResponseEntity<>(ue, httpHeaders, HttpStatus.CREATED);

    }
}
