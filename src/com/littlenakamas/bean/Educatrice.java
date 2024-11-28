package com.littlenakamas.bean;

public class Educatrice extends Employe{
    private String diplome;
    private int nbEnfant;

    public Educatrice(String diplome, int nbEnfant) {

        this.diplome = diplome;
        this.nbEnfant = nbEnfant;
    }
}
