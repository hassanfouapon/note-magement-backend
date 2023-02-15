package com.isj.models;

/**
 * importation des classes
 */


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * cette classe crée la table etudiant dans la base de données
 * cette classe herite de la classe CandidatController
 * @author traitement metier
 */

@Entity
@Table(name = "etudiant")
public class Etudiant extends Candidat implements Serializable {

    @Column(name = "matricule",unique=true,nullable = false)
    private String matricule;

    @Column(name = "code_authentification",unique=true,nullable = false)
    private String codeAuthentification;

    @OneToMany(mappedBy = "etudiant",cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    private List <Discipline> disciplines = new ArrayList<>();

    public Etudiant(String libelle, String description, String nom, String prenom, String email, String telephone, Date dateNaissance, Sexe sexe, Statut statut, String nomDeLaMere, String nomDuPere, String telephoneDeLaMere, String telephoneDuPere, String professionDuPere, String professionDelaMere, String regionOrigine, String ecoleOrigine, Classe classe, String matricule, String codeAuthentification,String lieuNaissance) {
        super(libelle, description, nom, prenom, email, telephone, dateNaissance, sexe, statut, nomDeLaMere, nomDuPere, telephoneDeLaMere, telephoneDuPere, professionDuPere, professionDelaMere, regionOrigine, ecoleOrigine, classe,lieuNaissance);
        this.matricule = matricule;
        this.codeAuthentification = codeAuthentification;
    }

    public Etudiant() {

    }

}
