/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.CustomerDAO;
import lk.ijse.starcabs.model.Customer;
import lk.ijse.starcabs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public Customer searchCustomer(Integer cId) {
        return customerDAO.searchCustomer(cId);
    }

    public boolean checkUsernamePassword(String user, String pass) {
        return customerDAO.checkUsernamePassword(user, pass);
    }

    public Customer searchCustomerByUserName(String userName) {
        return customerDAO.searchCustomerByUserName(userName);
    }

}
