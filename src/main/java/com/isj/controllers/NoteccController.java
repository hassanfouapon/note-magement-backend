package com.isj.controllers;

import com.isj.models.Enseignant;
import com.isj.models.NoteCC;
import com.isj.models.Securite;

import com.isj.models.Utilisateur;
import com.isj.payload.NoteCCRequest;
import com.isj.services.NoteccServices;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/isj/notecc")

// * cette classe permet de créer, lire, supprimer et mettre à jour un objet Notecc dans la base de donnée

public class NoteccController {
    @Autowired
    private NoteccServices noteccServices;
    @Autowired
    private UtilisateurServices utilisateurServices;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des Notecc

    @GetMapping
    public ResponseEntity<List<NoteCC>> getAllNotecc(){
        List<NoteCC> noteCCS = noteccServices.FindNotecc();
        return  new ResponseEntity<>(noteCCS, HttpStatus.OK);
    }
    @GetMapping({"/{noteccId}"})
    public ResponseEntity<NoteCC> getNotecc(@PathVariable Long noteccId) {
        return new ResponseEntity<>(noteccServices.findById(noteccId).get(), HttpStatus.OK);

    }
    // la fonction recoit une requete, supprime une note de cc avec l'ID correspondant
    @DeleteMapping({"/{id}"})
    public ResponseEntity<NoteCC> deleteNotecc(@PathVariable("id") Long id){
        noteccServices.deleteNotecc(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //fonction qui permet de mettre à jour les champs de l'objet Notecc
    public ResponseEntity<NoteCC> updateNotecc(@RequestBody NoteCC noteCC) {
        noteccServices.updateNotecc(noteCC);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("noteCC", "/api/isj/noteCC" + noteCC.getCode().toString());
        return new ResponseEntity<>(noteCC, httpHeaders, HttpStatus.CREATED);

    }
    // la fonction recoit une request Post, créer une nouvelle Notecc et le sauvegarde dans la BD
    @PostMapping("/save")
    public ResponseEntity<NoteCC> saveNotecc(@RequestBody NoteCCRequest noteCCRequest ){
        Utilisateur userCreateur = utilisateurServices.findById(noteCCRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(noteCCRequest.getModificateurId()).get();

        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

        NoteCC noteCC = new NoteCC(noteCCRequest.getLibelle(),noteCCRequest.getDescription(),noteCCRequest.getValeurNote());
        noteCC.setCreateur(userCreateur);
        noteCC.setModificateur(userModificateur);
        //signature
        noteCC.setDateCreation(date);
        noteCC.setDateModification(date);
        noteCC.setStatutVie(Securite.StatutVie.ACTIVE);
        NoteCC noteCC1 = noteccServices.insertNotecc(noteCC);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("noteCC", "api/isj/noteCC" + noteCC1.getCode().toString());
        return new ResponseEntity<>(noteCC1, httpHeaders, HttpStatus.CREATED);

    }



}
