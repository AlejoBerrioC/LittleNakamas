package com.littlenakamas.dao;

import com.littlenakamas.bean.Parent;
import com.littlenakamas.util.DbConnection;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.*;

public class ParentDAO {
    ResultSet rs;

    public void addParent(Parent newParent) {
        String query = "INSERT INTO Parent (numTel, nomPar, prePar)" +
                "VALUES (?, ?, ?)";

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setString(1, newParent.numTel);
            pst.setString(2, newParent.nomPar);
            pst.setString(3, newParent.prePar);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteParent(String numTel) {
        String query = "DELETE FROM Parent WHERE Numtel = ?";

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setString(1, numTel);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateParent(Parent parent, String numTel) {
        String query = "UPDATE Parent SET Numtel = ?, Nompar = ?, Prepar = ? WHERE Numtel = ?";

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setString(1, parent.numTel);
            pst.setString(2, parent.nomPar);
            pst.setString(3, parent.prePar);
            pst.setString(4, numTel);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Parent> getParents() {
        String query = "SELECT * FROM Parent";
        ArrayList<Parent> parents = new ArrayList<>();

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            rs = pst.executeQuery();
            while (rs.next()) {
                Parent parent = new Parent(rs.getString("Numtel"), rs.getString("Nompar"),
                        rs.getString("Prepar"));
                parents.add(parent);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return parents;
    }

    public Parent getParenByTel(String numTel) {
        String query = "SELECT * FROM Parent WHERE Numtel = ?";
        Parent parent = null;

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setString(1, numTel);
            rs = pst.executeQuery();
            if (rs.next()) {
                parent = new Parent(rs.getString("Numtel"),
                        rs.getString("Nompar"), rs.getString("Prepar"));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return parent;
    }
}
