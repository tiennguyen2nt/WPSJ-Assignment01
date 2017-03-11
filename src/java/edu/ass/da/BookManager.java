/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ass.da;

import edu.ass.entity.Book;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LongChimNgan
 */
public class BookManager {

    public static List<Book> getAll() {

        try {
            Connection connection = new Db().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement("select * from Book");

            ResultSet rs = statement.executeQuery();
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                books.add(book);
            }
            return books;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static Book getById(int id) {

        try {
            Connection connection = new Db().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement("select * from Book where id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Book book = null;
            if (rs.next()) {
                book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));

            }
            return book;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static List<Book> searchByName(String name) {
        try {
            Connection connection = new Db().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement("select * from Book where Name like ? or code like ?");
            statement.setString(1, "%" + name + "%");
            statement.setString(2, "%" + name.toUpperCase() + "%");

            ResultSet rs = statement.executeQuery();
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                books.add(book);
            }
            return books;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static void main(String[] args) {
        System.out.println(searchByName("D").get(0).getName());
    }

}
