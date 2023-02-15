package com.isj.payload;

import com.isj.models.Candidat;
import com.isj.models.Enseignement;
import com.isj.models.EstInscrit;
import com.isj.models.EstInscrit;

import java.util.Date;

public class EstInscritRequest {
    private String libelle;
    private String description;
    private EstInscrit.Statut statut;
    private long candidatId;
    private long enseignementId;
    private long createurId;
    private long modificateurId;


    public EstInscritRequest(String libelle, String description, EstInscrit.Statut statut, long candidatId, long enseignementId, long createurId, long modificateurId) {
        this.libelle = libelle;
        this.description = description;
        this.statut = statut;
        this.candidatId = candidatId;
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

    public EstInscrit.Statut getStatut() {
        return statut;
    }

    public void setStatut(EstInscrit.Statut statut) {
        this.statut = statut;
    }

    public long getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(long candidatId) {
        this.candidatId = candidatId;
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
