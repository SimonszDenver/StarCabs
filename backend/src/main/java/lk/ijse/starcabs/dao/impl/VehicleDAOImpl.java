/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.VehicleDAO;
import lk.ijse.starcabs.model.Orderdetails;
import lk.ijse.starcabs.model.Vehicle;
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
public class VehicleDAOImpl extends AbstractDao<Integer, Vehicle> implements VehicleDAO {

    public void addVehicle(Vehicle vehicle) {
        persist(vehicle);
    }

    public void deleteVehicle(int id) {
        Query query = getSession().createSQLQuery("delete from vehicle where vehicleID = :vId");
        query.setInteger("vId", id);
        query.executeUpdate();
    }

    public void updateVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Vehicle> getAllVehicles() {
        Criteria criteria = createEntityCriteria();
        return (List<Vehicle>) criteria.list();
    }

    public Vehicle searchVehicle(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("vehicleID", cId));
        return (Vehicle) criteria.uniqueResult();
    }

    public List<Vehicle> searchVehiclebyVehicleTypeId(Vehicle vehicle) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("vehicleTypeID.vehicleTypeID", vehicle.getVehicleTypeID().getVehicleTypeID()));
        List<Vehicle> list = criteria.list();
        return list;
    }

    public List<Vehicle> searchAvailableVehicle(Orderdetails orderdetails) {

        Query query = getSession().createSQLQuery("SELECT * FROM Vehicle v,Vehicletype vt WHERE vt.vehicleTypeID = v.vehicleTypeID AND vt.vehicleTypeID = '" + orderdetails.getVehicle().getVehicleTypeID().getVehicleTypeID() + "' AND vehicleID NOT IN(SELECT DISTINCT v.vehicleID FROM Vehicle v, OrderDetails od WHERE v.vehicleID=od.vehicleID AND od.dipatureDate between '" + orderdetails.getTime1() + "' and '" + orderdetails.getTime2() + "' OR od.arrivalDate between '" + orderdetails.getTime1() + "' and '" + orderdetails.getTime2() + "') AND v.district='" + orderdetails.getVehicle().getDistrict() + "'").addEntity(Vehicle.class);
        List<Vehicle> list = query.list();
        System.out.println(list.size() + " ->SIZEEEEEEEEEEEEEEEEEEEE");
        return list;
    }

}
