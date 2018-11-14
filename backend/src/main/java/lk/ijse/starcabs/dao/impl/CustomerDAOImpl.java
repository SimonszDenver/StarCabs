/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.CustomerDAO;
import lk.ijse.starcabs.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Repository
public class CustomerDAOImpl extends AbstractDao<Integer, Customer> implements CustomerDAO {

    public void addCustomer(Customer customer) {
        persist(customer);
    }

    public void deleteCustomer(int id) {
        Query query = getSession().createSQLQuery("delete from Customer where customerID = :cId");
        query.setInteger("cId", id);
        query.executeUpdate();
    }

    public void updateCustomer(Customer customer) {
        getSession().update(customer);
    }

    public List<Customer> getAllCustomers() {
        Criteria criteria = createEntityCriteria();
        return (List<Customer>) criteria.list();
    }

    public Customer searchCustomer(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("customerID", cId));
        return (Customer) criteria.uniqueResult();
    }

    public boolean checkUsernamePassword(String user, String pass) {
        boolean isFound = false;
        Query query = getSession().createSQLQuery("select * from Customer where userName=:user and password=:pass");
        query.setString("user", user);
        query.setString("pass", pass);
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {
            isFound = true;
        }
        return isFound;
    }

    public Customer searchCustomerByUserName(String userName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userName", userName));
        List<Customer> list = criteria.list();

        Customer customer = null;

        for (Customer c : list) {
            customer = c;

        }
        return customer;
    }

}
