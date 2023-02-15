package com.isj.models;
/**
 * importation des classes
 */

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * cette classe est superclasse qu'on ne crée pas en bd
 * cette class herite de la classe Securite
 * @author traitement metiér
 */

@MappedSuperclass
public class Personne extends Securite {

    public enum Statut {
        ACTIVE, NONACTIVE
    }

    public enum Sexe {
        MASCULIN, FEMININ
    }

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email", nullable = true, unique = false)
    private String email;

    @Column(name = "telephone",nullable = true, unique = false, length=13)
    private String telephone;

    @Column(name = "date_naissance", nullable = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateNaissance;

    @Column(name = "sexe",nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Column(name = "statut",nullable = false)
    @Enumerated(EnumType.STRING)
    private Statut statut;

    public Personne(String libelle, String description, String nom, String prenom, String email, String telephone, Date dateNaissance, Sexe sexe, Statut statut) {
        super(libelle, description);
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.statut = statut;
    }

    public Personne(){}

    public String getNom() {
        return nom;
    }
    public String getNomPrenom() {
        return nom+" "+prenom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }


    @Override
    public String getLibelle(){
        return nom + "-"+ prenom + "-" + telephone
                + "-" + email + "-" + dateNaissance + "-" + sexe + "-" + statut;
    }

    @Override
    public void setSignature() {
        setSignature(String.valueOf(hashCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNom(), getPrenom(), getEmail(), getTelephone(), getDateNaissance(), getSexe(), getStatut());
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", dateNaissance=" + dateNaissance +
                ", sexe=" + sexe +
                ", statut=" + statut +
                "} " + super.toString();
    }



}
