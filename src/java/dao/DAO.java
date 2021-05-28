/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import util.DBConnection;

/**
 *
 * @author Onur
 */
public class DAO {

    private DBConnection db;
    private Connection conn;

    public DBConnection getDb() {
        if (db == null) {
            db = new DBConnection();
        }
        return db;
    }

    public void setDb(DBConnection db) {
        this.db = db;
    }

    public Connection getConn() {
        if (conn == null) {
            conn = getDb().getDBConnection();
        }

        return conn;
    }

}
