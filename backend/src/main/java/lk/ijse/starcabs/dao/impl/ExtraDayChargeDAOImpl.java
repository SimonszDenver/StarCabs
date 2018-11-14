/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.ExtraDayChargeDAO;
import lk.ijse.starcabs.model.Extradaycharge;
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
public class ExtraDayChargeDAOImpl extends AbstractDao<Integer, Extradaycharge> implements ExtraDayChargeDAO {

    public void addExtraDayCharge(Extradaycharge extradaycharge) {
        persist(extradaycharge);
    }

    public void deleteExtraDayCharge(int id) {
        Query query = getSession().createSQLQuery("delete from ExtraDayCharge where extraDayChargeID = :edID");
        query.setInteger("edID", id);
        query.executeUpdate();
    }

    public void updateExtraDayCharge(Extradaycharge extradaycharge) {
        getSession().update(extradaycharge);
    }

    public List<Extradaycharge> getAllExtradaycharges() {
        Criteria criteria = createEntityCriteria();
        return (List<Extradaycharge>) criteria.list();
    }

    public Extradaycharge searchExtradaycharge(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("extraDayChargeID", cId));
        return (Extradaycharge) criteria.uniqueResult();
    }

}
