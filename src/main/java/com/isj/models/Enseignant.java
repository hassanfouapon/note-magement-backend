package com.isj.models;

/**
 * importation des classes
 */
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * cette classe crée la table enseignant dans la base de données
 * cette classe herite de la classe Personne
 * @author traitement metier
 */

@Entity
@Table(name ="enseignant")
public class Enseignant extends Personne implements Serializable {


    @Column(name = "qualification")
    private String qualification;

    @ManyToMany(mappedBy = "enseignants",fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    private List <Enseignement> enseignements = new ArrayList<>();

    public Enseignant(String libelle, String description, String nom, String prenom, String email, String telephone, Date dateNaissance, Sexe sexe, Statut statut, String qualification) {
        super(libelle, description, nom, prenom, email, telephone, dateNaissance, sexe, statut);
        this.qualification = qualification;
    }

    public Enseignant(){}

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<Enseignement> getEnseignements() {
        return enseignements;
    }

    public void setEnseignements(List<Enseignement> enseignements) {
        this.enseignements = enseignements;
    }

    @Override
    public String getLibelle(){
        return super.getLibelle() + "-" + qualification;
    }

    @Override
    public void setSignature() {
        setSignature(String.valueOf(hashCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getQualification());
    }

    @Override
    public String toString() {
        return getNom()+"-"+getPrenom();
    }
}
