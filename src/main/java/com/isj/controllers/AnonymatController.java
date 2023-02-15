package com.isj.controllers;

import com.isj.models.Anonymat;
import com.isj.services.AnonymatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/isj/anonymat")

public class AnonymatController {
    @Autowired
    private AnonymatService anonymatService;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des anonymat

    @GetMapping
    public ResponseEntity<List<Anonymat>> getAllAnonymat(){
        List<Anonymat> anonymats = anonymatService.FindAnonymat();
        return  new ResponseEntity<>(anonymats, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer un nouvel anonymat et la sauvegarde dans la BD

    public ResponseEntity<Anonymat> saveAnonymat(@RequestBody Anonymat anonymat){
        Anonymat anonymat1 = anonymatService.insert(anonymat);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("anonymat", "/api/isj/anonymat" + anonymat1.getCode().toString());
        return new ResponseEntity<>(anonymat1, httpHeaders, HttpStatus.CREATED);
    }
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Anonymat> deleteAnonymat(@PathVariable("id") Long id){
        anonymatService.deleteAnonymat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<Anonymat> updateAnonymat(@RequestBody Anonymat anonymat) {
        anonymatService.updateAnonymat(anonymat);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("anonymat", "/api/isj/anonymat" + anonymat.getCode().toString());
        return new ResponseEntity<>(anonymat, httpHeaders, HttpStatus.CREATED);

    }




}
