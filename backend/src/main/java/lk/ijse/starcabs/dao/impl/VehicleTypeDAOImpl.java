/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.VehicletypeDAO;
import lk.ijse.starcabs.model.Vehicletype;
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
public class VehicleTypeDAOImpl extends AbstractDao<Integer, Vehicletype> implements VehicletypeDAO {

    public void addVehicleType(Vehicletype vehicletype) {
        persist(vehicletype);
    }

    public void deleteVehicleType(int id) {
        Query query = getSession().createSQLQuery("delete from VehicleType where vehicleTypeID = :cId");
        query.setInteger("cId", id);
        query.executeUpdate();
    }

    public void updateVehicleType(Vehicletype vehicletype) {
        getSession().update(vehicletype);
    }

    public List<Vehicletype> getAllVehicleTypes() {
        Criteria criteria = createEntityCriteria();
        return (List<Vehicletype>) criteria.list();
    }

    public Vehicletype searchVehicleType(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("customerID", cId));
        return (Vehicletype) criteria.uniqueResult();
    }

}
