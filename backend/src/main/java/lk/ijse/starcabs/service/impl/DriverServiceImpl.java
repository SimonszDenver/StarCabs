/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.DriverDAO;
import lk.ijse.starcabs.model.Driver;
import lk.ijse.starcabs.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverDAO driverDAO;

    public void addDriver(Driver driver) {
        driverDAO.addDriver(driver);
    }

    public void deleteDriver(int id) {
        driverDAO.deleteDriver(id);
    }

    public void updateDriver(Driver driver) {
        driverDAO.updateDriver(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }

    public Driver searchDriver(Integer cId) {
        return driverDAO.searchDriver(cId);
    }

}
