/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class MySQLConnect {

    private static Connection conn;

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {

        String hostName = "54.187.59.174";
        String dbName = "ExercisePlan";
        String dbPort = "3306";
        String userName = "itangx";
        String password = "password";

        return getMySQLConnection(hostName, dbName, dbPort, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
            String dbPort, String userName, String password) throws SQLException,
            ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":" + dbPort + "/" + dbName + "?useSSL=false";

        conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }

    public static Connection getConn() {
        return conn;
    }

}
