package com.littlenakamas.dao;

import com.littlenakamas.bean.Educatrice;
import com.littlenakamas.bean.PersonnelAdministratif;
import com.littlenakamas.util.DbConnection;

import java.sql.*;
import java.util.*;

public class EmployeDAO {
    DbConnection conn = new DbConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void addTeacher(Educatrice newTeacher){
        String query = "INSERT INTO Employe (Nomemp, Preemp, Typeemp, Diplome, Nbenfant)" +
                "VALUES (?, ?, 'Educatrice', ?, ?)";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setString(1,newTeacher.nomEmp);
            pst.setString(2, newTeacher.preEmp);
            pst.setString(3, newTeacher.getDiplome());
            pst.setInt(4, newTeacher.getNbEnfant());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAdministratif(PersonnelAdministratif newAdminis){
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

    public void deleteEmploye(int numEmp){
        String query = "DELETE FROM Employe WHERE Numemp = ?";

        try {
            pst = conn.getConn().prepareStatement(query);
            pst.setInt(1, numEmp);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTeacher(Educatrice teacher, int numEmp){
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

    public void updateAdminis(PersonnelAdministratif adminis, int numEmp){
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
}
