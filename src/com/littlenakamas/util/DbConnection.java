package com.littlenakamas.util;

import java.sql.*;

public class DbConnection {
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String userName = "admin";
    private String password = "123";
    public Connection connection;
    public static Statement s;


    public DbConnection(){
        //Parametes de connection à la base de données
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("La connexion est etablie avec succes !");

        } catch (SQLException | ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("Echec de connection ! " + e.getMessage());
        }

    }

    public Connection getConn(){
        return this.connection;
    }

}
