/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.VehicleDAO;
import lk.ijse.starcabs.model.Orderdetails;
import lk.ijse.starcabs.model.Vehicle;
import lk.ijse.starcabs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Transactional
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDAO vehicleDAO;

    public void addVehicle(Vehicle vehicle) {
        vehicleDAO.addVehicle(vehicle);
    }

    public void deleteVehicle(int id) {
        vehicleDAO.deleteVehicle(id);
    }

    public void updateVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Vehicle> getAllVehicles() {
//        return driverDAO.getAllDrivers();
        return vehicleDAO.getAllVehicles();
    }

    public Vehicle searchVehicle(Integer cId) {
        return vehicleDAO.searchVehicle(cId);
    }

    public List<Vehicle> searchVehiclebyVehicleTypeId(Vehicle vehicle) {
        return vehicleDAO.searchVehiclebyVehicleTypeId(vehicle);
    }

    public List<Vehicle> searchAvailableVehicle(Orderdetails orderdetails) {
        return vehicleDAO.searchAvailableVehicle(orderdetails);
    }

}
