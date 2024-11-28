package com.littlenakamas.bean;

public class PersonnelAdministratif extends Employe{
    private String numTel;
    private String emailProf;

    public PersonnelAdministratif(int numEmp, String nomEmp, String preEmp, String numTel, String emailProf) {
        super(numEmp, nomEmp, preEmp);
        this.numTel = numTel;
        this.emailProf = emailProf;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmailProf() {
        return emailProf;
    }

    public void setEmailProf(String emailProf) {
        this.emailProf = emailProf;
    }
}
