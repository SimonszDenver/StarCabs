/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.LocationDAO;
import lk.ijse.starcabs.model.District;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */

@Repository
public class LocationDAOImpl extends AbstractDao<Integer, District> implements LocationDAO {

    public List<District> getAllDistrict() {
        Criteria criteria = createEntityCriteria();
        return (List<District>) criteria.list();
    }

}
