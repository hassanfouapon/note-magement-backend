package com.isj.models;
/**
 * importation des classes
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * cette classe crée la table note dans la base de données
 * cette classe herite de la classe Securite
 * @author traitement metier
 */

@Entity
@Table(name = "notecc",uniqueConstraints={
        @UniqueConstraint(columnNames = {"candidat","type_note_cc"})})

public class NoteCC extends Securite implements Serializable {

    @ManyToOne
    @JoinColumn(name = "candidat", nullable = false)
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "type_note_cc", nullable = false)
    private TypeNoteCC typeNoteCC;

    @Column(name = "valeur_note", nullable = false)
    private double valeurNote;

    public NoteCC(String libelle, String description, double valeurNote){}

    public NoteCC(String libelle, String description, Candidat candidat, TypeNoteCC typeNoteCC, double valeurNote) {
        super(libelle, description);
        this.candidat = candidat;
        this.typeNoteCC = typeNoteCC;
        this.valeurNote = valeurNote;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public TypeNoteCC getTypeNoteCC() {
        return typeNoteCC;
    }

    public void setTypeNoteCC(TypeNoteCC typeNoteCC) {
        this.typeNoteCC = typeNoteCC;
    }

    public double getValeurNote() {
        return valeurNote;
    }

    public void setValeurNote(double valeurNote) {
        this.valeurNote = valeurNote;
    }

    @Override
    public void setSignature() {
        setSignature(String.valueOf(hashCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValeurNote(), getCandidat(),getTypeNoteCC());
    }

    @Override
    public String toString() {
        return typeNoteCC.toString()+"-"+valeurNote+"";
    }

}
