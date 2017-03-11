/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ass.da;

import edu.ass.entity.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Author : Tien Nguyen Created on : Mar 10, 2017, 6:39:31 PM
 *
 */
public class OrderManager {

    public static List<Order> getBorrow() {
        try {
            Connection connection = new Db().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement("select * from Orders where status=true");

            ResultSet rs = statement.executeQuery();
            List<Order> orders = new LinkedList<>();
            while (rs.next()) {
                Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8), rs.getString(9));
                orders.add(o);
            }
            return orders;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static List<Order> getAll() {
        try {
            Connection connection = new Db().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement("select * from Orders ");

            ResultSet rs = statement.executeQuery();
            List<Order> orders = new LinkedList<>();
            while (rs.next()) {
                Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8), rs.getString(9));
                orders.add(o);
            }
            return orders;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean AddNew(Order o) {
        int result = 0;
        o.setId(getAll().size()+1);
        try {

            String sql = "INSERT INTO Orders VALUES(?,?,?,?,?,?,?,?,?)";
            Connection connection = new Db().getConnection();
            try (PreparedStatement prst = connection.prepareStatement(sql)) {
                prst.setInt(1, o.getId());
                prst.setInt(2, o.getIdbook());
                prst.setInt(3, o.getIdStaff());
                prst.setDate(4,  o.getBorrowDate());
                prst.setDate(5,  o.getReturnDate());
                prst.setString(6, o.getName());
                prst.setInt(7, o.getDay());
                prst.setBoolean(8, o.isStatus());
                prst.setString(9, o.getNote());
                
                result = prst.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
        
    }
}
