/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.ExtraMilageChargeDAO;
import lk.ijse.starcabs.model.Extramileagecharge;
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
public class ExtraMilageChargeDAOImpl extends AbstractDao<Integer, Extramileagecharge> implements ExtraMilageChargeDAO {

    public void addExtramileagecharge(Extramileagecharge extramileagecharge) {
        persist(extramileagecharge);
    }

    public void deleteExtramileagecharge(int id) {
        Query query = getSession().createSQLQuery("delete from ExtraMileageCharge where extraMileageChargeID  = :cId");
        query.setInteger("cId", id);
        query.executeUpdate();
    }

    public void updateExtramileagecharge(Extramileagecharge extramileagecharge) {
        getSession().update(extramileagecharge);
    }

    public List<Extramileagecharge> getAllExtramileagecharges() {
        Criteria criteria = createEntityCriteria();
        return (List<Extramileagecharge>) criteria.list();
    }

    public Extramileagecharge searchExtramileagecharge(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("extraMileageChargeID", cId));
        return (Extramileagecharge) criteria.uniqueResult();
    }

}
