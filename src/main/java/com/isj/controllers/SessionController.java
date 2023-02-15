package com.isj.controllers;

import com.isj.models.Securite;
import com.isj.models.Session;
import com.isj.models.Utilisateur;
import com.isj.payload.SessionRequest;
import com.isj.services.SessionServices;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/isj/Session")
public class SessionController {

    @Autowired
    private SessionServices sessionServices;
    @Autowired
    private UtilisateurServices utilisateurServices;

    // la fonction recoit une request de Get, l'execute et renvoie la liste des specialite

    @GetMapping
    public ResponseEntity<List<Session>> getAllSession(){
        List<Session> session = sessionServices.FindSession();
        return  new ResponseEntity<>(session, HttpStatus.OK);
    }
    // la fonction recoit une request Post, créer une nouvelle session et la sauvegarde dans la BD

    public ResponseEntity<Session> saveSession(@RequestBody Session session){
        Session session1 = sessionServices.insert(session);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("session", "/api/isj/session" + session1.getCode().toString());
        return new ResponseEntity<>(session1, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<Session> savesession(@RequestBody SessionRequest sessionRequest){

        Utilisateur userCreateur = utilisateurServices.findById(sessionRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(sessionRequest.getModificateurId()).get();
        Utilisateur UtilisateurId= utilisateurServices.findById(sessionRequest.getUtilisateurId()).get();


        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        java.sql.Date date_connection = new java.sql.Date(System.currentTimeMillis());
        java.sql.Date date_deconnection = new java.sql.Date(System.currentTimeMillis());

        Converter c = new Converter();

        try {
            Date dt_conx = c.convertStringToDate(sessionRequest.getDate_connection());
            Date dt_decon = c.convertStringToDate(sessionRequest.getDate_deconnection());


            date_connection = new java.sql.Date(dt_conx.getDate());
            date_deconnection = new java.sql.Date(dt_decon.getDate());


        }catch (Exception e){

        }


        Session session = new Session(sessionRequest.getLibelle(),sessionRequest.getDescription(),date_connection,date_deconnection, UtilisateurId,sessionRequest.getStatut(),sessionRequest.getMachine_cliente() );
        session.setCreateur(userCreateur);
        session.setModificateur(userModificateur);
        //la signature

        session.setStatutVie(Securite.StatutVie.ACTIVE);
        session.setDateCreation(date);
        session.setDateModification(date);

        Session session1= sessionServices.insert(session);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("session", "/api/isj/session" + session1.getCode().toString());
        return new ResponseEntity<>(session1, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Session> deleteSession(@PathVariable("id") Long id){
        sessionServices.deletesession(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<Session> updateSpecialite(@RequestBody Session session) {
        sessionServices.updatesession(session);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("session", "/api/isj/session" + session.getCode().toString());
        return new ResponseEntity<>(session, httpHeaders, HttpStatus.CREATED);

    }
}
