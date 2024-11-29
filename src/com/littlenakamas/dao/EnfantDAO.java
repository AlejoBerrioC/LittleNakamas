package com.littlenakamas.dao;

import com.littlenakamas.bean.Enfant;
import com.littlenakamas.util.DbConnection;

import java.sql.*;
import java.util.*;

public class EnfantDAO {
    DbConnection conn = new DbConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void addEnfant(Enfant newEnfant){
        String query = "INSERT INTO Enfant (Nomenf, Prenenf, Ageenf, Numtelparent)" +
                "VALUES (?, ?, ?, ?)";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, newEnfant.nomEnf);
            pst.setString(2, newEnfant.prenEnf);
            pst.setInt(3,newEnfant.ageEnf);
            pst.setString(4, newEnfant.getParentEnf().numTel);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEnfant(int numEnf){
        String query = "DELETE FROM Enfant WHERE numEnf = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setInt(1, numEnf);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEnfant(Enfant enfant, int numEnf){
        String query = "UPDATE Enfant SET Nomenf = ?, Preenf = ?, Ageenf = ?, Numtelparent = ? WHERE Numenf = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, enfant.nomEnf);
            pst.setString(2, enfant.prenEnf);
            pst.setInt(3, enfant.ageEnf);
            pst.setString(4, enfant.getParentEnf().numTel);
            pst.setInt(5,numEnf);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
