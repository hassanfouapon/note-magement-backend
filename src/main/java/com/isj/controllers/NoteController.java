package com.isj.controllers;


import com.isj.models.*;
import com.isj.services.AnonymatService;
import com.isj.services.EvaluationService;
import com.isj.services.NoteServices;
import com.isj.payload.NoteRequest;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/isj/Note")

public class NoteController {


    @Autowired
    private NoteServices noteServices;

    @Autowired
    private UtilisateurServices utilisateurServices;
    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private AnonymatService anonymatService;


    @GetMapping
    public ResponseEntity<List<Note>> getAllNote(){
        List<Note> notes;
        notes = noteServices.findNote();
        return  new ResponseEntity<>(notes, HttpStatus.OK);
    }

    public ResponseEntity<Note> save(@RequestBody Note note){
        Note note1 = noteServices.insert(note);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Note", "/api/isj/note" + note1.getCode().toString());
        return new ResponseEntity<>(note1, httpHeaders, HttpStatus.CREATED);
    }
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Note> deleteNote(@PathVariable("id") Long id){
        noteServices.deletenote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // la fonction recoit une request Post, créer un nouvel enseignant et le sauvegarde dans la BD

    @PostMapping("/save")
    public ResponseEntity<Note> saveNote(@RequestBody NoteRequest noteRequest){

        Utilisateur userCreateur = utilisateurServices.findById(noteRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(noteRequest.getModificateurId()).get();

        Evaluation evaluation = evaluationService.findById(noteRequest.getCodeevaluation()).get();
        Anonymat anonymat = anonymatService.findById(noteRequest.getCodeAnonymat()).get();

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        //Note note = new Note(noteRequest.getLibelle(),noteRequest.getDescription(),noteRequest.getValeur_note());

        Note note = new Note();
        note.setCreateur(userCreateur);
        note.setModificateur(userModificateur);
        //la signature
        note.setSignature("ts");

        note.setStatutVie(Securite.StatutVie.ACTIVE);
        note.setDateCreation(date);
        note.setDateModification(date);
        note.setAnonymat(anonymat);
        note.getEvaluation();
        note.getNumeroTable();
        note.getValeurNote();
        Note note1 = noteServices.insert(note);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("note", "/api/isj/note" + note.getCode().toString());
        return new ResponseEntity<>(note1, httpHeaders, HttpStatus.CREATED);
    }



}
