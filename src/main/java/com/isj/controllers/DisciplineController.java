package com.isj.controllers;

import com.isj.models.Discipline;
import com.isj.models.Enseignant;
import com.isj.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// * cette classe permet de créer, lire, supprimer et mettre à jour un objet Discipline dans la base de donnée

@RestController
@RequestMapping("/api/isj/discipline")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des disciplines
    @GetMapping
    public ResponseEntity<List<Discipline>> getAllDiscipline(){
        List<Discipline> disciplines = disciplineService.FindDiscipline();
        return  new ResponseEntity<>(disciplines, HttpStatus.OK);
    }

    // la fonction recoit une request Post, créer une nouvelle discipline et le sauvegarde dans la BD
    public ResponseEntity<Discipline> savediscipline(@RequestBody Discipline discipline){
        Discipline discipline1 = disciplineService.insert(discipline);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("discipline", "/api/isj/discipline" + discipline1.getCode().toString());
        return new ResponseEntity<>(discipline1, httpHeaders, HttpStatus.CREATED);
    }
    @GetMapping({"/{disciplineId}"})
    public ResponseEntity<Discipline> getDiscipline(@PathVariable Long disciplineId) {
        return new ResponseEntity<>(disciplineService.findById(disciplineId).get(), HttpStatus.OK);

    }

    // la fonction recoit une requete, supprime la discipline avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Enseignant> deleteDiscipline(@PathVariable("id") Long id){
        disciplineService.deletediscipline(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //fonction qui permet de mettre à jour les champs de l'objet Discipline
    public ResponseEntity<Discipline> updateUe(@RequestBody Discipline discipline) {
        disciplineService.updatediscipline(discipline);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("discipline", "/api/isj/discipline" + discipline.getCode().toString());
        return new ResponseEntity<>(discipline, httpHeaders, HttpStatus.CREATED);

    }
}
