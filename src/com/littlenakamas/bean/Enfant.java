package com.littlenakamas.bean;

public class Enfant implements Affectation {
    public int numEnf;
    public String nomEnf;
    public String prenEnf;
    public int ageEnf;
    private Parent parentEnf;

    public Enfant(int numEnf, String nomEnf, String prenEnf, int ageEnf, Parent parentEnf) {
        this.numEnf = numEnf;
        this.nomEnf = nomEnf;
        this.prenEnf = prenEnf;
        this.ageEnf = (ageEnf > 0) ? ageEnf : 0;
        this.parentEnf = parentEnf;
    }

    public Parent getParentEnf() {
        return parentEnf;
    }

    public int getNumEnf() {
        return numEnf;
    }

    public void setNumEnf(int numEnf) {
        this.numEnf = numEnf;
    }

    public String getNomEnf() {
        return nomEnf;
    }

    public void setNomEnf(String nomEnf) {
        this.nomEnf = nomEnf;
    }

    public String getPrenEnf() {
        return prenEnf;
    }

    public void setPrenEnf(String prenEnf) {
        this.prenEnf = prenEnf;
    }

    public int getAgeEnf() {
        return ageEnf;
    }

    public void setAgeEnf(int ageEnf) {
        this.ageEnf = ageEnf;
    }

    public void setParentEnf(Parent parentEnf) {
        this.parentEnf = parentEnf;
    }

    @Override
    public String affectedSection(int age) {
        if (age <= 2) {
            return "";
        } else if (age <= 4) {
            return "";
        } else if (age <= 6) {
            return "";
        } else {
            return "";
        }
    }
}
