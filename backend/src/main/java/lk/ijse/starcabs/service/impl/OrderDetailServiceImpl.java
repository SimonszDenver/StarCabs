/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.OrderDetailDAO;
import lk.ijse.starcabs.model.Orderdetails;
import lk.ijse.starcabs.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailDAO detailDAO;

    public void addOrderDetail(Orderdetails orderDetail) {
        detailDAO.addOrderDetail(orderDetail);
    }

    public void deleteOrderDetail(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateOrderDetail(Orderdetails orderDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Orderdetails> getAllOrderDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Orderdetails searchOrderDetail(Integer cId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
