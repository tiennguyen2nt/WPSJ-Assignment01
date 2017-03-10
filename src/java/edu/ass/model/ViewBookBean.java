/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ass.model;

import edu.ass.da.BookManager;
import edu.ass.da.OrderManager;
import edu.ass.entity.Book;
import edu.ass.entity.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tien Nguyen
 */
public final class ViewBookBean {

    private String keyword;
    private static List<Book> list;

    public ViewBookBean() {
        ViewBookBean.list = new ArrayList<>();
        getAll();
        getStatus();
    }

    public List<Book> getList() {
        return list;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void GetByKey() {
        list = BookManager.searchByName(keyword);
        getStatus();
    }

    public void getAll() {
        list = BookManager.getAll();
    }

    public void getStatus() {
        if (list != null) {
            List<Order> orders = OrderManager.getBorrow();
            if (orders != null) {
                for (int i = 0; i < list.size(); i++) {

                    for (int j = 0; j < orders.size(); j++) {

                        if (list.get(i).getId() == orders.get(j).getIdbook()) {
                            list.get(i).setQuantity(list.get(i).getQuantity() - 1);
                            if (list.get(i).getQuantity() <= 0) {
                                list.get(i).setStatus(true);
                            }
                        }
                    }
                }
            }

        }
    }
}
