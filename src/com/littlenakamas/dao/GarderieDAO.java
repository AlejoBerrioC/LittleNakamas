package com.littlenakamas.dao;

import com.littlenakamas.bean.Garderie;
import com.littlenakamas.util.DbConnection;

import java.sql.*;
import java.util.*;

public class GarderieDAO {
    DbConnection conn = new DbConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void addGarderie(Garderie newGarderie) {
        String query = "INSERT INTO Garderie (Nomgard, Capgard)" +
                "VALUES (?, ?)";

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setString(1, newGarderie.nomGuard);
            pst.setInt(2, newGarderie.capGuard);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGarderie(String nomGarderie) {
        String query = "DELETE FROM Garderie WHERE Nomgard = ?";

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setString(1, nomGarderie);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGarderie(Garderie garderie, String nomGarderie) {
        String query = "UPDATE Garderie SET Nomgarderie = ?, Capgarderie = ? WHERE Nomgarderie = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, garderie.nomGuard);
            pst.setInt(2, garderie.capGuard);
            pst.setString(3, nomGarderie);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
