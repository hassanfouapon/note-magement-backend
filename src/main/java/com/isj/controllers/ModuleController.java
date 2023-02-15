package com.isj.controllers;

import com.isj.models.Module;
import com.isj.models.Note;
import com.isj.models.Securite;
import com.isj.models.Utilisateur;
import com.isj.payload.ModuleRequest;
import com.isj.services.ModuleServices;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/isj/Module")
public class ModuleController {
    @Autowired
    private ModuleServices moduleServices;
    @Autowired
    private UtilisateurServices utilisateurServices;

    @GetMapping
    public ResponseEntity<List<Module>> getAllModule(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        System.out.println(dateFormat.format(cal.getTime()));

        List<Module> roles;
        roles = moduleServices.findmodule();
        return  new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping({"/{moduleId}"})
    public ResponseEntity<Module> getModule(@PathVariable Long moduleId) {
        return new ResponseEntity<>(moduleServices.findById(moduleId).get(), HttpStatus.OK);

    }

    // la fonction recoit une request Post, créer un nouvel enseignant et le sauvegarde dans la BD

    @PostMapping("/save")
    public ResponseEntity<Module> saveModule(@RequestBody ModuleRequest moduleRequest){

        Utilisateur userCreateur = utilisateurServices.findById(moduleRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(moduleRequest.getModificateurId()).get();

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());

        Module module = new Module(moduleRequest.getLibelle(),moduleRequest.getDescription(),moduleRequest.getCodeModule());
        module.setCreateur(userCreateur);
        module.setModificateur(userModificateur);
        //la signature
        module.setSignature("ts");


        Module module1 = moduleServices.insert(module);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("module", "/api/isj/module" + module1.getCode().toString());
        return new ResponseEntity<>(module1, httpHeaders, HttpStatus.CREATED);
    }


    @DeleteMapping({"/{id}"})
    public ResponseEntity<Note> delete(@PathVariable("id") Long id){
        moduleServices.deleteModule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
