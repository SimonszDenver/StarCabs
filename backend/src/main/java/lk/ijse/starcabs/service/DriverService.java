/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service;

import lk.ijse.starcabs.model.Driver;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface DriverService {

    void addDriver(Driver driver);

    void deleteDriver(int id);

    void updateDriver(Driver driver);

    List<Driver> getAllDrivers();

    Driver searchDriver(Integer cId);
}
