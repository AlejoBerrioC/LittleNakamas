package com.littlenakamas.dao;

import com.littlenakamas.bean.Employe;
import com.littlenakamas.bean.Enfant;
import com.littlenakamas.bean.Inscription;
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

    public Inscription getInscriptionByNumEnf(int numEnf) {
        String query = "SELECT * FROM Inscription WHERE Numenf = ?";
        Inscription inscription = null;

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setInt(1, numEnf);
            rs = pst.executeQuery();
            if (rs.next()) {
                inscription = new Inscription(rs.getDate("DATEINSCRIPTION"), EnfantDAO.getChildrenByNum(rs.getInt("Numenf")),
                        EmployeDAO.getEmployeByNumEmp(rs.getInt("Numemp")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inscription;
    }
}
