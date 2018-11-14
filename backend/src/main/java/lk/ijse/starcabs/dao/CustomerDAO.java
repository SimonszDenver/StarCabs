/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao;

import lk.ijse.starcabs.model.Customer;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface CustomerDAO {

    void addCustomer(Customer customer);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer);

    List<Customer> getAllCustomers();

    public Customer searchCustomer(Integer cId);

    boolean checkUsernamePassword(String user, String pass);

    Customer searchCustomerByUserName(String userName);
}
