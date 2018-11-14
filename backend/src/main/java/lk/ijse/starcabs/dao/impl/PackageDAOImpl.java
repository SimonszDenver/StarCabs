/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.PackageDAO;
import lk.ijse.starcabs.model.Packages;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Repository
public class PackageDAOImpl extends AbstractDao<Integer, Packages> implements PackageDAO {

    public void addPackage(Packages package1) {
        persist(package1);
    }

    public void deletePackage(int id) {
        Query query = getSession().createQuery("delete from packages where packageID = :pId");
        query.setInteger("pId", id);
        query.executeUpdate();
    }

    public void updatePackage(Packages package1) {
        getSession().update(package1);
    }

    public List<Packages> getAllPackages() {
        Criteria criteria = createEntityCriteria();
        return (List<Packages>) criteria.list();
    }

    public Packages searchPackage(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("packageID", cId));
        return (Packages) criteria.uniqueResult();
    }

    public List<Packages> searchPackagesByVehicleTypeId(Packages packages) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("vehicleTypeID.vehicleTypeID", packages.getVehicleTypeID().getVehicleTypeID()));
        List<Packages> list = criteria.list();
        return list;
    }

}
