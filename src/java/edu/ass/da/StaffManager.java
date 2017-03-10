/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ass.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Author : Tien Nguyen Created on : Mar 10, 2017, 5:05:48 PM
 *
 */
public class StaffManager {

    public static boolean Login(String user,String pass) {

        try {
            Connection connection = new Db().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement("select * from Staff where Username=? and Password=?");
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
           
            if (rs.next()) {
                return true;
            }
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        }
        return false;
    }
    
}
