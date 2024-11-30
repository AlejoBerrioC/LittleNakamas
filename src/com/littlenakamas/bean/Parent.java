package com.littlenakamas.bean;

public class Parent {
    public String numTel;
    public String nomPar;
    public String prePar;

    public Parent(String numTel, String nomPar, String prePar) {
        this.numTel = numTel;
        this.nomPar = nomPar;
        this.prePar = prePar;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNomPar() {
        return nomPar;
    }

    public void setNomPar(String nomPar) {
        this.nomPar = nomPar;
    }

    public String getPrePar() {
        return prePar;
    }

    public void setPrePar(String prePar) {
        this.prePar = prePar;
    }
}
