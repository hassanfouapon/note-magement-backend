package com.isj.controllers;

import com.isj.models.*;

import com.isj.payload.ClassRequest;
import com.isj.services.ClassService;
import com.isj.services.NiveauServices;
import com.isj.services.SpecialiteService;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/isj/classe")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private NiveauServices niveauServices;
    @Autowired
    private UtilisateurServices utilisateurServices;
    @Autowired
    private SpecialiteService specialiteService;


    @GetMapping
    public ResponseEntity<List<Classe>>getAllClass(){
        List<Classe> clas;
        clas = classService.FindClass();
        return  new ResponseEntity(getClass(), HttpStatus.OK);
    }

    public ResponseEntity<Classe> save(@RequestBody Classe clas){
        Classe clas1 = classService.insert(clas);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("class", "/api/isj/class" + clas1.toString());
        return new ResponseEntity<>(clas1, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<Classe> saveModule(@RequestBody ClassRequest classRequest){

        Utilisateur userCreateur = utilisateurServices.findById(classRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(classRequest.getModificateurId()).get();

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());

        Niveau niveau = niveauServices.findById(classRequest.getCodeniveau()).get();
        Specialite specialite = specialiteService.findById(classRequest.getCodespecialite()).get();

        Classe classe = new Classe(classRequest.getLibelle(),classRequest.getDescription(),niveau,specialite);
        classe.setCreateur(userCreateur);
        classe.setModificateur(userModificateur);
        //la signature

        classe.setStatutVie(Securite.StatutVie.ACTIVE);
        classe.setDateCreation(date);
        classe.setDateModification(date);

        Classe classe1 = classService.insert(classe);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("classe", "/api/isj/classe" + classe1.getCode().toString());
        return new ResponseEntity<>(classe1, httpHeaders, HttpStatus.CREATED);
    }



    @DeleteMapping({"/{id}"})
    public ResponseEntity<Class> deleteClass(@PathVariable("id") Long id){
        classService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

