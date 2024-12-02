package com.littlenakamas.dao;

import com.littlenakamas.bean.Enfant;
import com.littlenakamas.util.DbConnection;

import java.sql.*;
import java.util.*;

public class EnfantDAO {
    DbConnection conn = new DbConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void addEnfant(Enfant newEnfant, int numEmp) {
        String query = "INSERT INTO Enfant (Nomenf, Prenenf, Ageenf, Numtelparent)" +
                "VALUES (?, ?, ?, ?)";

        try {
            pst = conn.getConn().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, newEnfant.nomEnf);
            pst.setString(2, newEnfant.prenEnf);
            pst.setInt(3, newEnfant.ageEnf);
            pst.setString(4, newEnfant.getParentEnf().numTel);
            pst.executeUpdate();

            // Une fois l'enfant ajouter un ajoute son inscription
            new InscriptionDAO().addNewInscDate(new EnfantDAO().getChildrensByFullName(newEnfant.nomEnf, newEnfant.prenEnf),
                    EmployeDAO.getEmployeByNumEmp(numEmp));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEnfant(int numEnf) {
        String query = "DELETE FROM Enfant WHERE numEnf = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setInt(1, numEnf);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEnfant(Enfant enfant, int numEnf) {
        String query = "UPDATE Enfant SET Nomenf = ?, Prenenf = ?, Ageenf = ?, Numtelparent = ? WHERE Numenf = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, enfant.nomEnf);
            pst.setString(2, enfant.prenEnf);
            pst.setInt(3, enfant.ageEnf);
            pst.setString(4, enfant.getParentEnf().numTel);
            pst.setInt(5, numEnf);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Enfant> getChildrens() {
        String query = "SELECT Numenf, Nomenf, Prenenf, Ageenf, Numtelparent FROM Enfant";
        ArrayList<Enfant> enfants = new ArrayList<>();

        try {
            pst = conn.getConn().prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Enfant enfant = new Enfant(rs.getInt("Numenf"), rs.getString("Nomenf"),
                        rs.getString("Prenenf"), rs.getInt("Ageenf"), ParentDAO.getParenByTel(rs.getString("Numtelparent")));
                enfants.add(enfant);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enfants;
    }

    public static Enfant getChildrenByNum(int numEnf) {
        DbConnection conn = new DbConnection();
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT Numenf, Nomenf, Prenenf, Ageenf, Numtelparent FROM Enfant WHERE Numenf = ?";
        Enfant enfant = null;
        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setInt(1, numEnf);
            rs = pst.executeQuery();
            if (rs.next()) {
                enfant = new Enfant(rs.getInt("Numenf"), rs.getString("Nomenf"),
                        rs.getString("Prenenf"), rs.getInt("Ageenf"), ParentDAO.getParenByTel(rs.getString("Numtelparent")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enfant;
    }

    public ArrayList<Enfant> getChildrensBySearch(String search) {
        String query = "SELECT Numenf, Nomenf, Prenenf, Ageenf, Numtelparent FROM Enfant" +
                " WHERE Nomenf LIKE ? OR Prenenf LIKE ?";
        ArrayList<Enfant> enfants = new ArrayList<>();
        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, search + "%");
            pst.setString(2, search + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                Enfant enfant = new Enfant(rs.getInt("Numenf"), rs.getString("Nomenf"),
                        rs.getString("Prenenf"), rs.getInt("Ageenf"), ParentDAO.getParenByTel(rs.getString("Numtelparent")));
                enfants.add(enfant);
                System.out.println(enfant.nomEnf);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enfants;
    }

    public Enfant getChildrensByFullName(String name, String lastname) {
        String query = "SELECT Numenf, Nomenf, Prenenf, Ageenf, Numtelparent FROM Enfant" +
                " WHERE Nomenf LIKE ? AND Prenenf LIKE ?";
        Enfant enfant = null;
        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, lastname);
            rs = pst.executeQuery();
            if (rs.next()) {
                enfant = new Enfant(rs.getInt("Numenf"), rs.getString("Nomenf"),
                        rs.getString("Prenenf"), rs.getInt("Ageenf"), ParentDAO.getParenByTel(rs.getString("Numtelparent")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enfant;
    }
}
