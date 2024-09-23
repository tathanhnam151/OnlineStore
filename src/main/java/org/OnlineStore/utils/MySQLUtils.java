package org.OnlineStore.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUtils {
    public Connection getConnection()throws Exception {
        String urlMySQL = "jdbc:mysql://localhost:3306/MVCDemo";
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// nap driver
        }
        catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
        }
        try {
            con = DriverManager.getConnection(urlMySQL,"root","root");//ket noi
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return con;
    }
}
