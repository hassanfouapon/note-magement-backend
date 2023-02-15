package com.isj.payload;

import java.util.Date;

public class SpecialiteRequest {
    private String libelle;
    private String description;
    private long filiereId;
    private long createurId;
    private long modificateurId;


    public SpecialiteRequest(String libelle, String description, long filiereId, long createurId, long modificateurId) {
        this.libelle = libelle;
        this.description = description;
        this.filiereId = filiereId;
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

    public long getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(long filiereId) {
        this.filiereId = filiereId;
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
