/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.LocationDAO;
import lk.ijse.starcabs.model.District;
import lk.ijse.starcabs.service.Locationservice;
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
public class LocationServiceImpl implements Locationservice {

    @Autowired
    LocationDAO locationDAO;

    public List<District> getAllDistrict() {
        return locationDAO.getAllDistrict();
    }

}
