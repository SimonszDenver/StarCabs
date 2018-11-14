/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service;

import lk.ijse.starcabs.model.Orderdetails;
import lk.ijse.starcabs.model.Vehicle;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface VehicleService {

    void addVehicle(Vehicle vehicle);

    void deleteVehicle(int id);

    void updateVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle searchVehicle(Integer cId);

    List<Vehicle> searchVehiclebyVehicleTypeId(Vehicle vehicle);

    List<Vehicle> searchAvailableVehicle(Orderdetails orderdetails);
}
