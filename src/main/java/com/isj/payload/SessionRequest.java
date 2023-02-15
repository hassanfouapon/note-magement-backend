package com.isj.payload;


import com.isj.models.Securite;
import com.isj.models.Session;

import java.util.Date;

public class SessionRequest {


    private Long code;

    private String description;
    private String libelle;
    private String signature;
    private Securite.StatutVie statutVie;
    private String date_connection;
    private String date_deconnection;
    private String machine_cliente;
    private Session.Statut statut;
    private long utilisateurId;
    private long createurId;
    private long modificateurId;

    public SessionRequest(Long code, String description, String libelle, String signature, Securite.StatutVie statutVie, String date_connection, String date_deconnection, String machine_cliente, Session.Statut statut, long utilisateurId, long createurId, long modificateurId) {
        this.code = code;
        this.description = description;
        this.libelle = libelle;
        this.signature = signature;
        this.statutVie = statutVie;
        this.date_connection = date_connection;
        this.date_deconnection = date_deconnection;
        this.machine_cliente = machine_cliente;
        this.statut = statut;
        this.utilisateurId = utilisateurId;
        this.createurId = createurId;
        this.modificateurId = modificateurId;
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

    public String getDate_connection() {
        return date_connection;
    }

    public void setDate_connection(String date_connection) {
        this.date_connection = date_connection;
    }

    public String getDate_deconnection() {
        return date_deconnection;
    }

    public void setDate_deconnection(String date_deconnection) {
        this.date_deconnection = date_deconnection;
    }

    public String getMachine_cliente() {
        return machine_cliente;
    }

    public void setMachine_cliente(String machine_cliente) {
        this.machine_cliente = machine_cliente;
    }

    public Session.Statut getStatut() {
        return statut;
    }

    public void setStatut(Session.Statut statut) {
        this.statut = statut;
    }

    public long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(long utilisateurId) {
        this.utilisateurId = utilisateurId;
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

