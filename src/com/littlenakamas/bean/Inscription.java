package com.littlenakamas.bean;

import java.util.Date;

public class Inscription {
    private Date dateInscription;
    private Enfant enfant;
    private Employe employe;

    public Inscription(Date dateInscription, Enfant enfant) {
        this.dateInscription = dateInscription;
        this.enfant = enfant;
        this.employe = employe;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
