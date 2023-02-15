package com.isj.payload;

import java.util.Date;

public class TypeEvaluationRequest {
private String libelle;
private String description;
private float pourcentage;
private long enseignementId;
private long createurId;
private long modificateurId;


    public TypeEvaluationRequest(String libelle, String description, float pourcentage, long enseignementId, long createurId, long modificateurId) {
        this.libelle = libelle;
        this.description = description;
        this.pourcentage = pourcentage;
        this.enseignementId = enseignementId;
        this.createurId = createurId;
        this.modificateurId = modificateurId;
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

    public float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    public long getEnseignementId() {
        return enseignementId;
    }

    public void setEnseignementId(long enseignementId) {
        this.enseignementId = enseignementId;
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
