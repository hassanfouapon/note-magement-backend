package com.isj.payload;

import com.isj.models.Personne;


public class CandidatRequest {

    private Long code;

    private String dateCreation;
    private String dateModification;
    private String description;
    private String libelle;
    private String signature;
    private String statutVie;
    private String dateNaissance;
    private String email;
    private String nom;
    private String prenom;
    private Personne.Sexe sexe;
    private Personne.Statut statut;
    private String telephone;
    private String ecoleOrigine;
    private String lieuNaissance;
    private String nomMere;
    private String nomPere;
    private String professionMere;
    private String professionPere;
    private String regionOrigine;
    private String telephoneMere;
    private String telephonePere;
    private Long createurId;
    private Long modificateurId;
    private Long classeId;

    public CandidatRequest(Long code, String dateCreation, String dateModification, String description, String libelle, String signature, String statutVie, String dateNaissance, String email, String nom, String prenom, Personne.Sexe sexe, Personne.Statut statut, String telephone, String ecoleOrigine, String lieuNaissance, String nomMere, String nomPere, String professionMere, String professionPere, String regionOrigine, String telephoneMere, String telephonePere, Long createurId, Long modificateurId, Long classeId) {
        this.code = code;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.description = description;
        this.libelle = libelle;
        this.signature = signature;
        this.statutVie = statutVie;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.statut = statut;
        this.telephone = telephone;
        this.ecoleOrigine = ecoleOrigine;
        this.lieuNaissance = lieuNaissance;
        this.nomMere = nomMere;
        this.nomPere = nomPere;
        this.professionMere = professionMere;
        this.professionPere = professionPere;
        this.regionOrigine = regionOrigine;
        this.telephoneMere = telephoneMere;
        this.telephonePere = telephonePere;
        this.createurId = createurId;
        this.modificateurId = modificateurId;
        this.classeId = classeId;
    }


    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateModification() {
        return dateModification;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getStatutVie() {
        return statutVie;
    }

    public void setStatutVie(String statutVie) {
        this.statutVie = statutVie;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEcoleOrigine() {
        return ecoleOrigine;
    }

    public void setEcoleOrigine(String ecoleOrigine) {
        this.ecoleOrigine = ecoleOrigine;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getProfessionMere() {
        return professionMere;
    }

    public void setProfessionMere(String professionMere) {
        this.professionMere = professionMere;
    }

    public String getProfessionPere() {
        return professionPere;
    }

    public void setProfessionPere(String professionPere) {
        this.professionPere = professionPere;
    }

    public String getRegionOrigine() {
        return regionOrigine;
    }

    public void setRegionOrigine(String regionOrigine) {
        this.regionOrigine = regionOrigine;
    }

    public String getTelephoneMere() {
        return telephoneMere;
    }

    public void setTelephoneMere(String telephoneMere) {
        this.telephoneMere = telephoneMere;
    }

    public String getTelephonePere() {
        return telephonePere;
    }

    public void setTelephonePere(String telephonePere) {
        this.telephonePere = telephonePere;
    }

    public Long getCreateurId() {
        return createurId;
    }

    public void setCreateurId(Long createurId) {
        this.createurId = createurId;
    }

    public Long getModificateurId() {
        return modificateurId;
    }

    public void setModificateurId(Long modificateurId) {
        this.modificateurId = modificateurId;
    }

    public Long getClasseId() {
        return classeId;
    }

    public void setClasseId(Long classeId) {
        this.classeId = classeId;
    }
}
