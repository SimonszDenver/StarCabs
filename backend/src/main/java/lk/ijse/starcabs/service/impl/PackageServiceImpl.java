/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.PackageDAO;
import lk.ijse.starcabs.model.Packages;
import lk.ijse.starcabs.service.PackageService;
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
public class PackageServiceImpl implements PackageService {

    @Autowired
    PackageDAO packageDAO;

    public void addPackage(Packages package1) {
        packageDAO.addPackage(package1);
    }

    public void deletePackage(int id) {
        packageDAO.deletePackage(id);
    }

    public void updatePackage(Packages package1) {
        packageDAO.updatePackage(package1);
    }

    public List<Packages> getAllPackages() {
        return packageDAO.getAllPackages();
    }

    public Packages searchPackage(Integer cId) {
        return packageDAO.searchPackage(cId);
    }

    public List<Packages> searchPackagesByVehicleTypeId(Packages packages) {
        return packageDAO.searchPackagesByVehicleTypeId(packages);
    }

}
