/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.OrderDAO;
import lk.ijse.starcabs.model.Orders;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Repository
public class OrderDAOImpl extends AbstractDao<Integer, Orders> implements OrderDAO {

    public void addOrder(Orders order) {
        persist(order);
    }

    public void deleteOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateOrder(Orders order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Orders> getAllOrders() {
        Criteria criteria = createEntityCriteria();
        return (List<Orders>) criteria.list();
    }

    public Orders searchOrder(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("orderID", cId));
        return (Orders) criteria.uniqueResult();
    }

}
