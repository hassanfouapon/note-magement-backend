package com.isj.controllers;

import com.isj.models.Evaluation;
import com.isj.models.Securite;
import com.isj.models.TypeEvaluation;
import com.isj.models.Utilisateur;
import com.isj.payload.EvaluationRequest;
import com.isj.services.EvaluationService;
import com.isj.services.TypeEvaluationService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RequestMapping("/api/isj/evaluation")
@Controller
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;
    @Autowired
    private UtilisateurServices utilisateurServices;
    @Autowired
    private TypeEvaluationService typeEvaluationService;
    // la fonction recoit une request de Get, l'execute et renvoie la liste des evaluations
    @GetMapping
    public ResponseEntity<List<Evaluation>> getAllEvalution(){
        List<Evaluation> evaluations= evaluationService.findEvaluation();
        return new ResponseEntity<>(evaluations, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer une nouvelle evaluation et le sauvegarde dans la BD

    @PostMapping("/save")
    public ResponseEntity<Evaluation> saveEvaluation(@RequestBody EvaluationRequest evaluationRequest){

        Utilisateur userCreateur= utilisateurServices.findById(evaluationRequest.getCreateurId()).get();
        Utilisateur userModificateur=utilisateurServices.findById(evaluationRequest.getModificateurId()).get();
        TypeEvaluation typeEvaluation=typeEvaluationService.findById(evaluationRequest.getTypeEvaluationId()).get();

        java.sql.Date date= new java.sql.Date(System.currentTimeMillis());

        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();

        try {
          Date dt = c.convertStringToDate(evaluationRequest.getDateEvaluation());
        date1 = new java.sql.Date(dt.getDate());

        }catch (Exception e){

        }


        Evaluation evaluation= new Evaluation(evaluationRequest.getLibelle(),evaluationRequest.getDescription(),
                date1 ,evaluationRequest.getStatut(),typeEvaluation);

        //signature
        evaluation.setDateCreation(date);
        evaluation.setDateModification(date);
        evaluation.setStatutVie(Securite.StatutVie.ACTIVE);


        Evaluation evaluation1= evaluationService.insertEvaluation(evaluation);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("evaluation","/api/isj/evaluation" + evaluation1.getCode().toString());
        return new ResponseEntity<>(evaluation1,httpHeaders,HttpStatus.CREATED);

    }
    // la fonction recoit une requete, supprime l'evalution avec l'ID correspondant

    @DeleteMapping({"/ {id}"})
    public ResponseEntity <Evaluation> deleteEvalution(@PathVariable("id") Long id){
        evaluationService.deleteEvaluation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //fonction qui permet de mettre à jour les champs de l'objet evaluation
    public ResponseEntity<Evaluation> updateEvaluation(@RequestBody Evaluation evaluation){
        evaluationService.updateEvaluation(evaluation);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("evaluation","/api/isj/evaluation" + evaluation.getCode().toString());
        return new ResponseEntity<>(evaluation,httpHeaders,HttpStatus.CREATED);
    }
}
