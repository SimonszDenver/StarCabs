/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.DriverDAO;
import lk.ijse.starcabs.model.Driver;
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
public class DriverDAOImpl extends AbstractDao<Integer, Driver> implements DriverDAO {

    public void addDriver(Driver driver) {
        persist(driver);
    }

    public void deleteDriver(int id) {
        Query query = getSession().createSQLQuery("delete from Driver where driverID = :dId");
        query.setInteger("dId", id);
        query.executeUpdate();
    }

    public void updateDriver(Driver driver) {
        getSession().update(driver);
    }

    public List<Driver> getAllDrivers() {
        Criteria criteria = createEntityCriteria();
        return (List<Driver>) criteria.list();
    }

    public Driver searchDriver(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("driverID", cId));
        return (Driver) criteria.uniqueResult();
    }

}
