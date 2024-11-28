package com.littlenakamas.bean;

public class Educatrice extends Employe{
    private String diplome;
    private int nbEnfant;

    public Educatrice(int numEmp, String nomEmp, String preEmp, String diplome, int nbEnfant) {
        super(numEmp, nomEmp, preEmp);
        this.diplome = diplome;
        this.nbEnfant = nbEnfant;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public int getNbEnfant() {
        return nbEnfant;
    }

    public void setNbEnfant(int nbEnfant) {
        this.nbEnfant = nbEnfant;
    }
}
