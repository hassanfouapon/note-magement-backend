package com.isj.payload;

import com.isj.models.Evaluation;
import com.isj.models.Personne;

import java.util.Date;

public class EvaluationRequest {
    private String libelle;
    private String description;
    private String dateEvaluation;
    private Evaluation.Statut statut;
    private long typeEvaluationId;
    private long createurId;
    private long modificateurId;


    public EvaluationRequest(String libelle, String description, String dateEvaluation, Evaluation.Statut statut, long typeEvaluationId, long createurId, long modificateurId) {
        this.libelle = libelle;
        this.description = description;
        this.dateEvaluation = dateEvaluation;
        this.statut = statut;
        this.typeEvaluationId = typeEvaluationId;
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

    public String getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(String dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public Evaluation.Statut getStatut() {
        return statut;
    }

    public void setStatut(Evaluation.Statut statut) {
        this.statut = statut;
    }

    public long getTypeEvaluationId() {
        return typeEvaluationId;
    }

    public void setTypeEvaluationId(long typeEvaluationId) {
        this.typeEvaluationId = typeEvaluationId;
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
