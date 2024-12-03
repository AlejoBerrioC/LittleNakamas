package com.littlenakamas.dao;

import com.littlenakamas.bean.Employe;
import com.littlenakamas.bean.Enfant;
import com.littlenakamas.bean.Inscription;
import com.littlenakamas.util.DbConnection;

import java.sql.*;

public class InscriptionDAO {
    ResultSet rs;

    public void addNewInscDate(Enfant enfant, Employe employe) {
        String query = "INSERT INTO Inscription (Numenf, Numemp)" +
                "VALUES (?, ?)";

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
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
        EmployeDAO employeDAO = new EmployeDAO();
        EnfantDAO enfantDAO = new EnfantDAO();

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setInt(1, numEnf);
            rs = pst.executeQuery();
            if (rs.next()) {
                inscription = new Inscription(rs.getDate("DATEINSCRIPTION"), enfantDAO.getChildrenByNum(rs.getInt("Numenf")),
                        employeDAO.getEmployeByNumEmp(rs.getInt("Numemp")));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inscription;
    }
}
