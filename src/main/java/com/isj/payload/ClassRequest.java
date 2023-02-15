package com.isj.payload;


import com.isj.models.Securite;

import java.util.Date;

public class ClassRequest {

    private Long code;


    private String libelle;
    private String description;
    private long codeniveau;
    private long codespecialite;
    private long createurId;
    private long modificateurId;

    public ClassRequest(Long code, String libelle, String description, long codeniveau, long codespecialite, long createurId, long modificateurId) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.codeniveau = codeniveau;
        this.codespecialite = codespecialite;
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

    public long getCodeniveau() {
        return codeniveau;
    }

    public void setCodeniveau(long codeniveau) {
        this.codeniveau = codeniveau;
    }

    public long getCodespecialite() {
        return codespecialite;
    }

    public void setCodespecialite(long codespecialite) {
        this.codespecialite = codespecialite;
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
