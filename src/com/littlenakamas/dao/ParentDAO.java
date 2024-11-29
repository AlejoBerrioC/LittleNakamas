package com.littlenakamas.dao;

import com.littlenakamas.bean.Parent;
import com.littlenakamas.util.DbConnection;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.*;

public class ParentDAO {
    DbConnection conn = new DbConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void addParent(Parent newParent) {
        String query = "INSERT INTO Parent (numTel, nomPar, prePar)" +
                "VALUES (?, ?, ?)";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, newParent.numTel);
            pst.setString(2, newParent.nomPar);
            pst.setString(3, newParent.prePar);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteParent(String numTel){
        String query = "DELETE FROM Parent WHERE Numtel = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, numTel);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateParent(Parent parent, String numTel){
        String query = "UPDATE Parent SET Numtel = ?, Nompar = ?, Prepar = ? WHERE Numtel = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, parent.numTel);
            pst.setString(2, parent.nomPar);
            pst.setString(3, parent.prePar);
            pst.setString(4, numTel);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
