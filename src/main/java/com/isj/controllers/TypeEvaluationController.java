package com.isj.controllers;

import com.isj.models.Enseignement;
import com.isj.models.Securite;
import com.isj.models.TypeEvaluation;
import com.isj.models.Utilisateur;
import com.isj.payload.TypeEvaluationRequest;
import com.isj.services.EnseignementService;
import com.isj.services.TypeEvaluationService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/isj/typeEvaluation")
@Controller
public class TypeEvaluationController {
    @Autowired
    TypeEvaluationService typeEvaluationService;
    @Autowired
    private UtilisateurServices utilisateurServices;
    @Autowired
    private EnseignementService enseignementService;
    // la fonction recoit une request de Get, l'execute et renvoie la liste des typeEvaluation
    @GetMapping
    public ResponseEntity<List<TypeEvaluation>> getAllTypeEvaluation(){
        List<TypeEvaluation> typeEvaluations=typeEvaluationService.findTypeEvaluation();
        return new ResponseEntity<>(typeEvaluations, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer un nouveau typeEvaluation et le sauvegarde dans la BD

    @PostMapping("/save")
    public ResponseEntity<TypeEvaluation> saveTypeEvaluation(@RequestBody TypeEvaluationRequest typeEvaluationRequest){
        Utilisateur userUtilisateur= utilisateurServices.findById(typeEvaluationRequest.getCreateurId()).get();
        Utilisateur userModificateur= utilisateurServices.findById(typeEvaluationRequest.getModificateurId()).get();
        Enseignement userEnseignement= enseignementService.findById(typeEvaluationRequest.getEnseignementId()).get();

        java.sql.Date date= new java.sql.Date(System.currentTimeMillis());

        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();

        TypeEvaluation typeEvaluation= new TypeEvaluation(typeEvaluationRequest.getLibelle(),typeEvaluationRequest.getDescription(),
                typeEvaluationRequest.getPourcentage(),userEnseignement);



        //signature
        typeEvaluation.setDateCreation(date);
        typeEvaluation.setDateModification(date);
        typeEvaluation.setStatutVie(Securite.StatutVie.ACTIVE);



        TypeEvaluation typeEvaluation1= typeEvaluationService.insertTypeEvaluation(typeEvaluation);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("typeEvaluation","/api/isj/typeEvaluation" + typeEvaluation1.getCode().toString());
        return new ResponseEntity<>(typeEvaluation1,httpHeaders,HttpStatus.CREATED);
    }
    // la fonction recoit une requete, supprime typeEvaluation avec l'ID correspondant
    @DeleteMapping({"/ {id}"})
    public ResponseEntity<TypeEvaluation> deleteTypeEvaluation(@PathVariable("id") Long id){
        typeEvaluationService.deleteTypeEvaluation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //fonction qui permet de mettre à jour les champs de l'objet typeEvaluation
    public ResponseEntity<TypeEvaluation> updateTypeEvaluation(@RequestBody TypeEvaluation typeEvaluation){
        typeEvaluationService.updateTypeEluation(typeEvaluation);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("typeEvaluation", "/api/isj/typeEvaluation");
        return new ResponseEntity<>(typeEvaluation,httpHeaders,HttpStatus.CREATED);
    }

}
