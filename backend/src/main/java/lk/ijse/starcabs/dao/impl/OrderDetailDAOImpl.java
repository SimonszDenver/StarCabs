/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.OrderDetailDAO;
import lk.ijse.starcabs.model.Orderdetails;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Repository
public class OrderDetailDAOImpl extends AbstractDao<Integer, Orderdetails> implements OrderDetailDAO {

    public void addOrderDetail(Orderdetails orderDetail) {
        persist(orderDetail);
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
