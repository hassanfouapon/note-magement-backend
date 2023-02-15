package com.isj.payload;

import com.isj.models.Classe;
import com.isj.models.Personne;

import java.util.Date;

public class EtudiantRequest {
    private Long code;
    private String libelle;
    private String description;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String dateNaissance;
    private Personne.Sexe sexe;
    private Personne.Statut statut;
    private String nomDeLaMere;
    private String nomDuPere;
    private  String telephoneDeLaMere;
    private String telephoneDuPere;
    private String professionDuPere;
    private String professionDelaMere;
    private String regionOrigine;
    private String ecoleOrigine;
    private long classeId;
    private String matricule;
    private String codeAuthentification;
    private String lieuNaissance;
    private long createurId;
    private long modificateurId;


    public EtudiantRequest(Long code, String libelle, String description, String nom, String prenom, String email, String telephone, String dateNaissance, Personne.Sexe sexe, Personne.Statut statut, String nomDeLaMere, String nomDuPere, String telephoneDeLaMere, String telephoneDuPere, String professionDuPere, String professionDelaMere, String regionOrigine, String ecoleOrigine, long classeId, String matricule, String codeAuthentification, String lieuNaissance, long createurId, long modificateurId) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.statut = statut;
        this.nomDeLaMere = nomDeLaMere;
        this.nomDuPere = nomDuPere;
        this.telephoneDeLaMere = telephoneDeLaMere;
        this.telephoneDuPere = telephoneDuPere;
        this.professionDuPere = professionDuPere;
        this.professionDelaMere = professionDelaMere;
        this.regionOrigine = regionOrigine;
        this.ecoleOrigine = ecoleOrigine;
        this.classeId = classeId;
        this.matricule = matricule;
        this.codeAuthentification = codeAuthentification;
        this.lieuNaissance = lieuNaissance;
        this.createurId = createurId;
        this.modificateurId = modificateurId;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Personne.Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Personne.Sexe sexe) {
        this.sexe = sexe;
    }

    public Personne.Statut getStatut() {
        return statut;
    }

    public void setStatut(Personne.Statut statut) {
        this.statut = statut;
    }

    public String getNomDeLaMere() {
        return nomDeLaMere;
    }

    public void setNomDeLaMere(String nomDeLaMere) {
        this.nomDeLaMere = nomDeLaMere;
    }

    public String getNomDuPere() {
        return nomDuPere;
    }

    public void setNomDuPere(String nomDuPere) {
        this.nomDuPere = nomDuPere;
    }

    public String getTelephoneDeLaMere() {
        return telephoneDeLaMere;
    }

    public void setTelephoneDeLaMere(String telephoneDeLaMere) {
        this.telephoneDeLaMere = telephoneDeLaMere;
    }

    public String getTelephoneDuPere() {
        return telephoneDuPere;
    }

    public void setTelephoneDuPere(String telephoneDuPere) {
        this.telephoneDuPere = telephoneDuPere;
    }

    public String getProfessionDuPere() {
        return professionDuPere;
    }

    public void setProfessionDuPere(String professionDuPere) {
        this.professionDuPere = professionDuPere;
    }

    public String getProfessionDelaMere() {
        return professionDelaMere;
    }

    public void setProfessionDelaMere(String professionDelaMere) {
        this.professionDelaMere = professionDelaMere;
    }

    public String getRegionOrigine() {
        return regionOrigine;
    }

    public void setRegionOrigine(String regionOrigine) {
        this.regionOrigine = regionOrigine;
    }

    public String getEcoleOrigine() {
        return ecoleOrigine;
    }

    public void setEcoleOrigine(String ecoleOrigine) {
        this.ecoleOrigine = ecoleOrigine;
    }

    public long getClasseId() {
        return classeId;
    }

    public void setClasseId(long classeId) {
        this.classeId = classeId;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCodeAuthentification() {
        return codeAuthentification;
    }

    public void setCodeAuthentification(String codeAuthentification) {
        this.codeAuthentification = codeAuthentification;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public long getCreateurId() {
        return createurId;
    }

    public void setCreateurId(long createurId) {
        this.createurId = createurId;
    }

    public long getModificateurId() {
        return modificateurId;
    }

    public void setModificateurId(long modificateurId) {
        this.modificateurId = modificateurId;
    }
}
