package com.isj.payload;

import com.isj.models.Semestre;
import com.isj.models.UE;

public class EnseignementRequest {


    private Long code;


    private String libelle;
    private String description;
    private int heuresDeCours;
    private String programmeDeCours;
    private long codesemestre;
    private long codeue;
    private double credit;
    private long createurId;
    private long modificateurId;

    public EnseignementRequest(Long code, String libelle, String description, int heuresDeCours, String programmeDeCours, long codesemestre, long codeue, double credit, long createurId, long modificateurId) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.heuresDeCours = heuresDeCours;
        this.programmeDeCours = programmeDeCours;
        this.codesemestre = codesemestre;
        this.codeue = codeue;
        this.credit = credit;
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

    public int getHeuresDeCours() {
        return heuresDeCours;
    }

    public void setHeuresDeCours(int heuresDeCours) {
        this.heuresDeCours = heuresDeCours;
    }

    public String getProgrammeDeCours() {
        return programmeDeCours;
    }

    public void setProgrammeDeCours(String programmeDeCours) {
        this.programmeDeCours = programmeDeCours;
    }

    public long getCodesemestre() {
        return codesemestre;
    }

    public void setCodesemestre(long codesemestre) {
        this.codesemestre = codesemestre;
    }

    public long getCodeue() {
        return codeue;
    }

    public void setCodeue(long codeue) {
        this.codeue = codeue;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
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




