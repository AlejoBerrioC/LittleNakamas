package com.littlenakamas.bean;

import java.util.ArrayList;

public class Garderie {
    public String nomGuard;
    public int capGuard;
    private ArrayList<Enfant> listEnf;
    private ArrayList<Employe> listEmp;

    public Garderie(String nomGuard, int capGuard) {
        this.nomGuard = nomGuard;
        this.capGuard = capGuard;
        this.listEnf = new ArrayList<>();
        this.listEmp = new ArrayList<>();
    }

    public ArrayList<Employe> getListEmp() {
        return listEmp;
    }

    public void setListEmp(ArrayList<Employe> listEmp) {
        this.listEmp = listEmp;
    }

    public ArrayList<Enfant> getListEnf() {
        return listEnf;
    }

    public void setListEnf(ArrayList<Enfant> listEnf) {
        this.listEnf = listEnf;
    }

    public String getNomGuard() {
        return nomGuard;
    }

    public void setNomGuard(String nomGuard) {
        this.nomGuard = nomGuard;
    }

    public int getCapGuard() {
        return capGuard;
    }

    public void setCapGuard(int capGuard) {
        this.capGuard = capGuard;
    }
}
