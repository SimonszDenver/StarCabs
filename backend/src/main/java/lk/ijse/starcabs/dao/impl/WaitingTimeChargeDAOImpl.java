/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao.impl;

import lk.ijse.starcabs.dao.AbstractDao;
import lk.ijse.starcabs.dao.WaitingTimeChargeDAO;
import lk.ijse.starcabs.model.Waitingtimecharge;
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
public class WaitingTimeChargeDAOImpl extends AbstractDao<Integer, Waitingtimecharge> implements WaitingTimeChargeDAO {

    public void addWaitingtimecharge(Waitingtimecharge waitingtimecharge) {
        persist(waitingtimecharge);
    }

    public void deleteWaitingtimecharge(int id) {
        Query query = getSession().createSQLQuery("delete from WaitingTimeCharge where waitingTimeChargeID = :cId");
        query.setInteger("cId", id);
        query.executeUpdate();
    }

    public void updateWaitingtimecharge(Waitingtimecharge waitingtimecharge) {
        getSession().update(waitingtimecharge);
    }

    public List<Waitingtimecharge> getAllWaitingtimecharges() {
        Criteria criteria = createEntityCriteria();
        return (List<Waitingtimecharge>) criteria.list();
    }

    public Waitingtimecharge searchWaitingtimecharge(Integer cId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("waitingTimeChargeID", cId));
        return (Waitingtimecharge) criteria.uniqueResult();
    }

}
