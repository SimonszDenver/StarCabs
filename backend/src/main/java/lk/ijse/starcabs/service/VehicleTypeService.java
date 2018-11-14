/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service;

import lk.ijse.starcabs.model.Vehicletype;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface VehicleTypeService {

    void addVehicleType(Vehicletype vehicletype);

    void deleteVehicleType(int id);

    void updateVehicleType(Vehicletype vehicletype);

    List<Vehicletype> getAllVehicleTypes();

    public Vehicletype searchVehicleType(Integer cId);
}
