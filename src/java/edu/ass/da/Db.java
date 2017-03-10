/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ass.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LongChimNgan
 */
public class Db {
    private Connection connection = null;
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        
        if(connection == null){
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String user = "sa";
            String url = "jdbc:derby://localhost:1527/AptechLibrary";
            connection =  DriverManager.getConnection(url, user, user);
            return connection;
        }
        return connection;
    }
}
