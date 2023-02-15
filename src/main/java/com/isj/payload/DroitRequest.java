package com.isj.payload;

import com.isj.models.Role;

public class DroitRequest {
    private Long code;


    private String libelle;
    private String description;
    private String categorie;
    private boolean lecture;
    private boolean ecriture;
    private boolean modification;
    private boolean suppression;
    private long createurId;
    private long modificateurId;

    public DroitRequest(Long code, String libelle, String description, String categorie, boolean lecture, boolean ecriture, boolean modification, boolean suppression, long createurId, long modificateurId) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.categorie = categorie;
        this.lecture = lecture;
        this.ecriture = ecriture;
        this.modification = modification;
        this.suppression = suppression;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public boolean isLecture() {
        return lecture;
    }

    public void setLecture(boolean lecture) {
        this.lecture = lecture;
    }

    public boolean isEcriture() {
        return ecriture;
    }

    public void setEcriture(boolean ecriture) {
        this.ecriture = ecriture;
    }

    public boolean isModification() {
        return modification;
    }

    public void setModification(boolean modification) {
        this.modification = modification;
    }

    public boolean isSuppression() {
        return suppression;
    }

    public void setSuppression(boolean suppression) {
        this.suppression = suppression;
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
