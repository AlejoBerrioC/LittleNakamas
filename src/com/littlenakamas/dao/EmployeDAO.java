package com.littlenakamas.dao;

import com.littlenakamas.bean.Educatrice;
import com.littlenakamas.bean.Employe;
import com.littlenakamas.bean.PersonnelAdministratif;
import com.littlenakamas.util.DbConnection;

import java.sql.*;
import java.util.*;

public class EmployeDAO {
    DbConnection conn = new DbConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void addTeacher(Educatrice newTeacher) {
        String query = "INSERT INTO Employe (Nomemp, Preemp, Typeemp, Diplome, Nbenfant)" +
                "VALUES (?, ?, 'Educatrice', ?, ?)";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, newTeacher.nomEmp);
            pst.setString(2, newTeacher.preEmp);
            pst.setString(3, newTeacher.getDiplome());
            pst.setInt(4, newTeacher.getNbEnfant());
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAdministratif(PersonnelAdministratif newAdminis) {
        String query = "INSERT INTO Employe (Nomemp, Preemp, Typeemp, Numtel, Emailprof)" +
                "VALUES (?, ?, 'PersonnelAdministratif', ?, ?)";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, newAdminis.nomEmp);
            pst.setString(2, newAdminis.preEmp);
            pst.setString(3, newAdminis.getNumTel());
            pst.setString(4, newAdminis.getEmailProf());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmploye(int numEmp) {
        String query = "DELETE FROM Employe WHERE Numemp = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setInt(1, numEmp);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTeacher(Educatrice teacher, int numEmp) {
        String query = "UPDATE Employe SET Nomemp = ?, Preemp = ?, Diplome = ?, Nbenfant = ? WHERE Numemp = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, teacher.nomEmp);
            pst.setString(2, teacher.preEmp);
            pst.setString(3, teacher.getDiplome());
            pst.setInt(4, teacher.getNbEnfant());
            pst.setInt(5, numEmp);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAdminis(PersonnelAdministratif adminis, int numEmp) {
        String query = "UPDATE Employe SET Nomemp = ?, Preemp = ?, Numtel = ?, Emailprof = ? WHERE Numemp = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, adminis.nomEmp);
            pst.setString(2, adminis.preEmp);
            pst.setString(3, adminis.getNumTel());
            pst.setString(4, adminis.getEmailProf());
            pst.setInt(5, numEmp);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Employe> getEmployes() {
        String query = "SELECT Numemp, Nomemp, Preemp FROM Employe";
        ArrayList<Employe> employes = new ArrayList<>();
        try {
            pst = conn.getConn().prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Employe employe = new Employe(rs.getInt("Numemp"),
                        rs.getString("Nomemp"), rs.getString("Preemp"));
                employes.add(employe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employes;
    }

    public ArrayList<Educatrice> getTeachers() {
        String query = "SELECT Numemp, Nomemp, Preemp, Diplome, Nbenfant FROM Employe WHERE Typeemp = 'Educatrice'";
        ArrayList<Educatrice> teachers = new ArrayList<>();

        try {
            pst = conn.getConn().prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Educatrice educatrice = new Educatrice(rs.getInt("Numemp"), rs.getString("Nomemp"),
                        rs.getString("Preemp"), rs.getString("Diplome"),
                        rs.getInt("Nbenfant"));
                teachers.add(educatrice);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }

    public ArrayList<PersonnelAdministratif> getAdminis() {
        String query = "SELECT Numemp, Nomemp, Preemp, Numtel, Emailprof FROM Employe WHERE Typeemp = 'PersonnelAdministratif'";
        ArrayList<PersonnelAdministratif> administratifs = new ArrayList<>();

        try {
            pst = conn.getConn().prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                PersonnelAdministratif administratif = new PersonnelAdministratif(rs.getInt("Numemp"), rs.getString("Nomemp"),
                        rs.getString("Preemp"), rs.getString("Numtel"),
                        rs.getString("Emailprof"));
                administratifs.add(administratif);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return administratifs;
    }

    public static Employe getEmployeByNumEmp(int numEmp) {
        DbConnection conn = new DbConnection();
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT Numemp, Nomemp, Preemp FROM Employe WHERE Numemp = ?";
        Employe employe = null;
        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setInt(1, numEmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                employe = new Employe(rs.getInt("Numemp"), rs.getString("Nomemp"),
                        rs.getString("Preemp"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employe;
    }

    public Employe getEmployeByLogin(String name, String lastname, String password) {
        DbConnection conn = new DbConnection();
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT * FROM Employe WHERE NOMEMP = ? AND PREEMP = ? AND PASSWORD = ?";
        Employe employe = null;
        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1, lastname);
            pst.setString(2, name);
            pst.setString(3, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                employe = new Employe(rs.getInt("Numemp"), rs.getString("Nomemp"),
                        rs.getString("Preemp"));
                System.out.println("Name: " + employe.nomEmp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employe;
    }

}
