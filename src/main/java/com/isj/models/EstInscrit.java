package com.isj.models;

/**
 * importation des classes
 */
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * cette classe crée la table est_inscrit dans la base de données
 * cette classe herite de la classe Securite
 * @author traitement metier
 */


@Entity
@Table(name = "est_inscrit",uniqueConstraints={
        @UniqueConstraint(columnNames = {"candidat_inscrit", "enseignement"})
})

public class EstInscrit extends Securite implements Serializable {

    public EstInscrit(Candidat candidat) {
        this.candidatInscrit=candidat;
    }

    public enum Statut {
       VALIDE, NONVALIDE
   }

    @Column(name = "statut")
    @Enumerated(EnumType.STRING)
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "candidat_inscrit")
    private Candidat candidatInscrit;

    /*@OneToOne(mappedBy = "estInscrit")
    private Note note;

    @OneToOne(mappedBy = "estInscrit")
    private Anonymat anonymat;*/

    @ManyToOne
    @JoinColumn(name="enseignement")
    private Enseignement enseignement;

    public EstInscrit(String libelle, String description, Statut statut, Candidat candidatInscrit, Enseignement enseignement) {
        super(libelle, description);
        this.statut = statut;
        this.candidatInscrit = candidatInscrit;
        this.enseignement = enseignement;
    }

    public  EstInscrit(){}

    public EstInscrit.Statut getStatut() {
        return statut;
    }

    public void setStatut(EstInscrit.Statut statut) {
        this.statut = statut;
    }

    public Candidat getCandidatInscrit() {
        return candidatInscrit;
    }

    public void setCandidatInscrit(Candidat candidatInscrit) {
        this.candidatInscrit = candidatInscrit;
    }

    /*public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }*/

    public Enseignement getEnseignement() {
        return enseignement;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    /*@Override
    public String getLibelle(){
        return candidatInscrit.getLibelle() +"-" +enseignement.getLibelle()+ "-"+statut
                +"-"+ note.getLibelle();
                 {
        return Objects.hash(super.hashCode(), getNiveau(), getSpecialite());
    }*/
    @Override
    public void setSignature() {
        setSignature(String.valueOf(hashCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCode(), getEnseignement(), getCandidatInscrit());
    }

    @Override
    public String toString() {
        //System.out.println("candidatInscrit:"+candidatInscrit.toString());
        //System.out.println("enseignement:"+enseignement.toString());
        return (candidatInscrit!=null?(candidatInscrit.getNom()+" "+ candidatInscrit.getPrenom()):"") +(enseignement!=null? ("-"+enseignement.toString()):"");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstInscrit that = (EstInscrit) o;
        return Objects.equals(candidatInscrit, that.candidatInscrit) &&
                Objects.equals(enseignement, that.enseignement);
    }
}
