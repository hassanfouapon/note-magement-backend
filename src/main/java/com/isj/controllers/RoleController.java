package com.isj.controllers;

import com.isj.models.Enseignant;
import com.isj.models.Role;
import com.isj.models.Utilisateur;
import com.isj.payload.RoleRequest;
import com.isj.services.RoleServices;
import com.isj.services.UtilisateurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/isj/role")
public class RoleController {

    @Autowired
    private RoleServices roleServices;

    @Autowired
    private UtilisateurServices utilisateurServices;



    @GetMapping
    public ResponseEntity<List<Role>> getAllRole(){
        List<Role> roles;
        roles = roleServices.findRole();
        return  new ResponseEntity<>(roles, HttpStatus.OK);
    }

    public ResponseEntity<Role> save(@RequestBody Role role){
        Role role1 = roleServices.insert(role);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Role", "/api/isj/role" + role1.getCode().toString());
        return new ResponseEntity<>(role1, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<Role> saveRole(@RequestBody RoleRequest roleRequest){

        Utilisateur userCreateur = utilisateurServices.findById(roleRequest.getCreateurId()).get();
        Utilisateur userModificateur = utilisateurServices.findById(roleRequest.getModificateurId()).get();

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());

        Role role = new Role(roleRequest.getLibelle(),roleRequest.getDescription());
        role.setCreateur(userCreateur);
        role.setModificateur(userModificateur);
        //la signature
        role.setSignature("ts");


        Role role1 = roleServices.insert(role);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("role", "/api/isj/role" + role1.getCode().toString());
        return new ResponseEntity<>(role1, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Enseignant> deleteRole(@PathVariable("id") Long id){
        roleServices.deleterole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
