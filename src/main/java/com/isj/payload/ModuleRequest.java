package com.isj.payload;


import com.isj.models.Securite;
import com.isj.models.Utilisateur;
import lombok.Data;

import java.util.Date;


public class ModuleRequest {

    private Long code;

    private String codeModule;
    private String libelle;
    private String description;
    private String signature;
    private Securite.StatutVie statutVie;
    private long createurId;
    private long modificateurId;


    public ModuleRequest(Long code, String codeModule, String libelle, String description, String signature, Securite.StatutVie statutVie, long createurId, long modificateurId) {
        this.code = code;
        this.codeModule = codeModule;
        this.libelle = libelle;
        this.description = description;
        this.signature = signature;
        this.statutVie = statutVie;
        this.createurId = createurId;
        this.modificateurId = modificateurId;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCodeModule() {
        return codeModule;
    }

    public void setCodeModule(String codeModule) {
        this.codeModule = codeModule;
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
