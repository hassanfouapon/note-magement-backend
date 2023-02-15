package com.isj.payload;


import com.isj.models.Securite;

import java.util.Date;

public class SemestreRequest {


    private Long code;

    private String description;
    private String libelle;
    private String signature;
    private Securite.StatutVie statutVie;
    private String date_cloture;
    private String date_debut;

    private long createurId;
    private long modificateurId;

    private long anne_academique;


    public SemestreRequest(Long code, String description, String libelle, String signature, Securite.StatutVie statutVie, String date_cloture, String date_debut, long createurId, long modificateurId, long anne_academique) {
        this.code = code;
        this.description = description;
        this.libelle = libelle;
        this.signature = signature;
        this.statutVie = statutVie;
        this.date_cloture = date_cloture;
        this.date_debut = date_debut;
        this.createurId = createurId;
        this.modificateurId = modificateurId;
        this.anne_academique = anne_academique;
    }


    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
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

    public Securite.StatutVie getStatutVie() {
        return statutVie;
    }

    public void setStatutVie(Securite.StatutVie statutVie) {
        this.statutVie = statutVie;
    }

    public String getDate_cloture() {
        return date_cloture;
    }

    public void setDate_cloture(String date_cloture) {
        this.date_cloture = date_cloture;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
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

    public long getAnne_academique() {
        return anne_academique;
    }

    public void setAnne_academique(long anne_academique) {
        this.anne_academique = anne_academique;
    }
}
