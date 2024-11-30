package com.littlenakamas.bean;

public class Employe {
    public int numEmp;
    public String nomEmp;
    public String preEmp;

    public Employe(int numEmp, String nomEmp, String preEmp) {
        this.numEmp = numEmp;
        this.nomEmp = nomEmp;
        this.preEmp = preEmp;
    }

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getPreEmp() {
        return preEmp;
    }

    public void setPreEmp(String preEmp) {
        this.preEmp = preEmp;
    }
}
