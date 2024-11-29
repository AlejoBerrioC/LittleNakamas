package com.littlenakamas.dao;

import com.littlenakamas.bean.Employe;
import com.littlenakamas.bean.Enfant;
import com.littlenakamas.util.DbConnection;

import java.sql.*;

public class InscriptionDAO {
    DbConnection conn = new DbConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void addNewInscDate(Enfant enfant, Employe employe) {
        String query = "INSERT INTO Inscription (Numenf, Numemp)" +
                "VALUES (?, ?)";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setInt(1, enfant.numEnf);
            pst.setInt(2, employe.numEmp);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Date getDate() {
        String query = "SELECT ";

        return null;
    }
}
