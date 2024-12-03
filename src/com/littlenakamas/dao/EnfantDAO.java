package com.littlenakamas.dao;

import com.littlenakamas.bean.Enfant;
import com.littlenakamas.bean.Parent;
import com.littlenakamas.util.DbConnection;

import java.sql.*;
import java.util.*;

public class EnfantDAO {
    ResultSet rs;

    public void addEnfant(Enfant newEnfant, int numEmp) {
        String query = "INSERT INTO Enfant (Nomenf, Prenenf, Ageenf, Numtelparent)" +
                "VALUES (?, ?, ?, ?)";
        EmployeDAO employeDAO = new EmployeDAO();
        EnfantDAO enfantDAO = new EnfantDAO();
        InscriptionDAO inscriptionDAO = new InscriptionDAO();

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
        {
            pst.setString(1, newEnfant.nomEnf);
            pst.setString(2, newEnfant.prenEnf);
            pst.setInt(3, newEnfant.ageEnf);
            pst.setString(4, newEnfant.getParentEnf().numTel);
            pst.executeUpdate();

            // Une fois l'enfant ajouter un ajoute son inscription
            inscriptionDAO.addNewInscDate(enfantDAO.getChildrensByFullName(newEnfant.nomEnf, newEnfant.prenEnf),
                    employeDAO.getEmployeByNumEmp(numEmp));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEnfant(int numEnf) {
        String query = "DELETE FROM Enfant WHERE numEnf = ?";

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setInt(1, numEnf);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEnfant(Enfant enfant, int numEnf) {
        String query = "UPDATE Enfant SET Nomenf = ?, Prenenf = ?, Ageenf = ?, Numtelparent = ? WHERE Numenf = ?";

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
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
        ParentDAO parentDAO = new ParentDAO();

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query)) {
            rs = pst.executeQuery();
            while (rs.next()) {
                Enfant enfant = new Enfant(rs.getInt("Numenf"), rs.getString("Nomenf"),
                        rs.getString("Prenenf"), rs.getInt("Ageenf"), parentDAO.getParenByTel(rs.getString("Numtelparent")));
                enfants.add(enfant);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enfants;
    }

    public Enfant getChildrenByNum(int numEnf) {
        ParentDAO parentDAO = new ParentDAO();
        String query = "SELECT Numenf, Nomenf, Prenenf, Ageenf, Numtelparent FROM Enfant WHERE Numenf = ?";
        Enfant enfant = null;
        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setInt(1, numEnf);
            rs = pst.executeQuery();
            if (rs.next()) {
                enfant = new Enfant(rs.getInt("Numenf"), rs.getString("Nomenf"),
                        rs.getString("Prenenf"), rs.getInt("Ageenf"), parentDAO.getParenByTel(rs.getString("Numtelparent")));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enfant;
    }

    public ArrayList<Enfant> getChildrensBySearch(String search) {
        String query = "SELECT Numenf, Nomenf, Prenenf, Ageenf, Numtelparent FROM Enfant" +
                " WHERE Nomenf LIKE ? OR Prenenf LIKE ?";
        ArrayList<Enfant> enfants = new ArrayList<>();
        ParentDAO parentDAO = new ParentDAO();

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setString(1, search + "%");
            pst.setString(2, search + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                Enfant enfant = new Enfant(rs.getInt("Numenf"), rs.getString("Nomenf"),
                        rs.getString("Prenenf"), rs.getInt("Ageenf"), parentDAO.getParenByTel(rs.getString("Numtelparent")));
                enfants.add(enfant);
                System.out.println(enfant.nomEnf);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enfants;
    }

    public Enfant getChildrensByFullName(String name, String lastname) {
        String query = "SELECT Numenf, Nomenf, Prenenf, Ageenf, Numtelparent FROM Enfant" +
                " WHERE Nomenf LIKE ? AND Prenenf LIKE ?";
        Enfant enfant = null;
        ParentDAO parentDAO = new ParentDAO();

        try (Connection conn = new DbConnection().getConn();
             PreparedStatement pst = conn.prepareStatement(query))
        {
            pst.setString(1, name);
            pst.setString(2, lastname);
            rs = pst.executeQuery();
            if (rs.next()) {
                enfant = new Enfant(rs.getInt("Numenf"), rs.getString("Nomenf"),
                        rs.getString("Prenenf"), rs.getInt("Ageenf"), parentDAO.getParenByTel(rs.getString("Numtelparent")));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enfant;
    }
}
