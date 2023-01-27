package com.hemebiotech.analytics;

import java.util.Objects;

public class Maladie {

    private String nom;
    private int nbApparitions;

    public Maladie(String nom) {
        this.nom = nom;
        this.nbApparitions = 1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbApparitions() {
        return nbApparitions;
    }

    public void setNbApparitions(int nbApparitions) {
        this.nbApparitions = nbApparitions;
    }

    @Override
    public String toString() {
        return "Maladie{" +
                "nom='" + nom + '\'' +
                ", nbApparitions=" + nbApparitions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maladie maladie = (Maladie) o;
        return Objects.equals(nom, maladie.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    public int compareTo(Maladie m) {
        return this.nom.compareTo(m.getNom());
    }
}
