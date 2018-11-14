/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service;

import lk.ijse.starcabs.model.Orderdetails;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface OrderDetailService {

    void addOrderDetail(Orderdetails orderDetail);

    void deleteOrderDetail(int id);

    void updateOrderDetail(Orderdetails orderDetail);

    List<Orderdetails> getAllOrderDetails();

    Orderdetails searchOrderDetail(Integer cId);
}
