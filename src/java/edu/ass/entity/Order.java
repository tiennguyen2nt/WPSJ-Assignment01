/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ass.entity;

import java.sql.Date;





/**
 * 
 * Author     : Tien Nguyen
 * Created on : Mar 10, 2017, 6:32:03 PM
 *
 */
public class Order {
    private int id;
    private int idbook;
    private int idStaff;
    private Date borrowDate;
    private Date returnDate;
    private String name;
    private int day;
    private boolean status;  //Trạng thái đã trả hay chưa;
    private String note;
    

    public Order() {
    }

    public Order(int id, int idbook, int idStaff, Date borrowDate, Date returnDate, String name, int day, boolean status, String note) {
        this.id = id;
        this.idbook = idbook;
        this.idStaff = idStaff;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.name = name;
        this.day = day;
        this.status = status;
        this.note = note;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdbook() {
        return idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
