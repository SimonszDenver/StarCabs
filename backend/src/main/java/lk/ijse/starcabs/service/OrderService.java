/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service;

import lk.ijse.starcabs.model.Orders;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface OrderService {

    void addOrder(Orders order);

    void deleteOrder(int id);

    void updateOrder(Orders order);

    List<Orders> getAllOrders();

    Orders searchOrder(Integer cId);
}
