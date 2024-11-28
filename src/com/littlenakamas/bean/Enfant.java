package com.littlenakamas.bean;

public class Enfant implements Affectation{
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

    public void setParentEnf(Parent parentEnf) {
        this.parentEnf = parentEnf;
    }

    @Override
    public String affectedSection(int age) {
        if (age <= 2){
            return "";
        }
        else if (age <= 4) {
            return "";
        }
        else if (age <= 6) {
            return "";
        } else {
            return "";
        }
    }
}
