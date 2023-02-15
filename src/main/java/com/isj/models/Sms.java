package com.isj.models;

/**
 * importation des classes
 */
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * cette classe crée la table Sms dans la base de données
 * cette classe herite de la classe message
 * @author traitement metier
 */

@Entity
@Table(name = "sms")
public class Sms extends Message implements Serializable {

    @Override
    public String toString() {
        return "Sms{} " + super.toString();
    }

    public Sms(String libelle, String description, String contenu, String destinataire, String emetteur) {
        super(libelle, description, contenu, destinataire, emetteur);
    }

    public Sms() {
    }

    @Override
    public void setSignature() {
        setSignature(String.valueOf(hashCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String getLibelle(){
        return "Sms";
    }

}
