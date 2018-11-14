/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.WaitingTimeChargeDAO;
import lk.ijse.starcabs.model.Waitingtimecharge;
import lk.ijse.starcabs.service.WaitingTimeChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Transactional
@Service
public class WaitingTimeCharge implements WaitingTimeChargeService {
    @Autowired
    WaitingTimeChargeDAO waitingTimeChargeDAO;

    public void addWaitingtimecharge(Waitingtimecharge waitingtimecharge) {
        waitingTimeChargeDAO.addWaitingtimecharge(waitingtimecharge);
    }

    public void deleteWaitingtimecharge(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateWaitingtimecharge(Waitingtimecharge waitingtimecharge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Waitingtimecharge> getAllWaitingtimecharges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Waitingtimecharge searchWaitingtimecharge(Integer cId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
