package com.isj.models;

/**
 * importation des classes
 */

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * cette classe crée la table Role dans la base de données
 * cette classe herite de la classe Securite
 * @author traitement metier
 */

@Entity
@Table(name = "role")
public class Role extends Securite implements Serializable {

    @OneToMany(mappedBy = "role",cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    private List <Droit> droits = new ArrayList<>();

    @ManyToMany(mappedBy = "roles",cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    private List <Utilisateur> utilisateurs = new ArrayList<>();

    public Role(String libelle, String description) {
        super(libelle, description);
    }

    public Role() {
    }

    public List<Droit> getDroits() {
        return droits;
    }

    public void setDroits(List<Droit> droits) {
        this.droits = droits;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return getDroits().equals(role.getDroits()) &&
                getUtilisateurs().equals(role.getUtilisateurs());
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
    public String toString() {
        return getLibelle();
    }
}
