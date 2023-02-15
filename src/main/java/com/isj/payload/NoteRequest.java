package com.isj.payload;



public class NoteRequest {


    private long code;

    private String description;
    private String libelle;

    private long codeAnonymat;
    private int numero_table;
    private double valeur_note;
    private long createurId;
    private long modificateurId;
    private long codeest_inscrit;
    private long codeevaluation;

    public NoteRequest(long code, String description, String libelle, long codeAnonymat, int numero_table, double valeur_note, long createurId, long modificateurId, long codeest_inscrit, long codeevaluation) {
        this.code = code;
        this.description = description;
        this.libelle = libelle;
        this.codeAnonymat = codeAnonymat;
        this.numero_table = numero_table;
        this.valeur_note = valeur_note;
        this.createurId = createurId;
        this.modificateurId = modificateurId;
        this.codeest_inscrit = codeest_inscrit;
        this.codeevaluation = codeevaluation;
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
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

    public long getCodeAnonymat() {
        return codeAnonymat;
    }

    public void setCodeAnonymat(long codeAnonymat) {
        this.codeAnonymat = codeAnonymat;
    }

    public int getNumero_table() {
        return numero_table;
    }

    public void setNumero_table(int numero_table) {
        this.numero_table = numero_table;
    }

    public double getValeur_note() {
        return valeur_note;
    }

    public void setValeur_note(double valeur_note) {
        this.valeur_note = valeur_note;
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

    public long getCodeest_inscrit() {
        return codeest_inscrit;
    }

    public void setCodeest_inscrit(long codeest_inscrit) {
        this.codeest_inscrit = codeest_inscrit;
    }

    public long getCodeevaluation() {
        return codeevaluation;
    }

    public void setCodeevaluation(long codeevaluation) {
        this.codeevaluation = codeevaluation;
    }
}
