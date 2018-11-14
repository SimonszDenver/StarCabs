/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao;

import lk.ijse.starcabs.model.Packages;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface PackageDAO {

    void addPackage(Packages package1);

    void deletePackage(int id);

    void updatePackage(Packages package1);

    List<Packages> getAllPackages();

    List<Packages> searchPackagesByVehicleTypeId(Packages packages);

    Packages searchPackage(Integer cId);
}
