/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Onur
 */
public class DBConnection {

    public DBConnection() {

    }
    private static DBConnection dbc;

    public static DBConnection getDbc() {
        if (dbc == null) {
            dbc = new DBConnection();
        }
        return dbc;
    }

    private final String url = "jdbc:postgresql://localhost/askerienvanter";
    private final String user = "postgres";
    private final String password = "123onur";

    public Connection getDBConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }

}


/*


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yahya YİLDİRİM
 
public class DBConnection {

    private final String url = "jdbc:postgresql://localhost/AskerEnvanter";
    private final String user = "postgres";
    private final String password = "123yahya";

    public Connection connect() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }

}


 */
