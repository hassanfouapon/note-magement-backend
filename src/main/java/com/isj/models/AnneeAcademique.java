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
 * cette classe crée la table annee_academique dans la base de données
 * cette classe herite de la classe Securite
 * @author traitement metier
 */


@Entity
@Table(name = "annee_academique")
public class AnneeAcademique extends Securite implements Serializable {

    @Column(name = "date_debut", unique=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Column(name = "date_cloture")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCloture;

    @OneToMany(mappedBy = "anneeAcademique",cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    private List <Semestre> semestres = new ArrayList<>();

    public AnneeAcademique(String libelle, String description, Date dateDebut, Date dateCloture) {
        super(libelle, description);
        this.dateDebut = dateDebut;
        this.dateCloture = dateCloture;
    }

    public AnneeAcademique(){}

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    @Override
    public void setSignature() {
        setSignature(String.valueOf(hashCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDateDebut(), getDateCloture());
    }

    @Override
    public String toString() {

        //return getDescription();
        //return getLibelle();
        return (getDateDebut().getYear()+1900)+"/"+(getDateCloture().getYear()+1900);
    }
}
