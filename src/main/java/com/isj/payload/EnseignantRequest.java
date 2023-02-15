package com.isj.payload;

import com.isj.models.Personne;


public class EnseignantRequest {

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
    private String qualification;
    private long createurId;
    private long modificateurId;

    public EnseignantRequest(Long code, String libelle, String description, String nom, String prenom, String email, String telephone, String dateNaissance, Personne.Sexe sexe, Personne.Statut statut, String qualification, long createurId, long modificateurId) {
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
        this.qualification = qualification;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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
