/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.VehicletypeDAO;
import lk.ijse.starcabs.model.Vehicletype;
import lk.ijse.starcabs.service.VehicleTypeService;
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
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    VehicletypeDAO vehicletypeDAO;

    public void addVehicleType(Vehicletype vehicletype) {
        vehicletypeDAO.addVehicleType(vehicletype);
    }

    public void deleteVehicleType(int id) {
        vehicletypeDAO.deleteVehicleType(id);
    }

    public void updateVehicleType(Vehicletype vehicletype) {
        vehicletypeDAO.updateVehicleType(vehicletype);

    }

    public List<Vehicletype> getAllVehicleTypes() {
        return vehicletypeDAO.getAllVehicleTypes();
    }

    public Vehicletype searchVehicleType(Integer cId) {
        return vehicletypeDAO.searchVehicleType(cId);
    }

}
