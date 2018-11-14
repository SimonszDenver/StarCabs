/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.ExtraDayChargeDAO;
import lk.ijse.starcabs.model.Extradaycharge;
import lk.ijse.starcabs.service.ExtraDayChargeService;
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
public class ExtraDayChargeServiceImpl implements ExtraDayChargeService {
    @Autowired
    ExtraDayChargeDAO extraDayChargeDAO;

    public void addExtraDayCharge(Extradaycharge extradaycharge) {
        extraDayChargeDAO.addExtraDayCharge(extradaycharge);
    }

    public void deleteExtraDayCharge(int id) {
        extraDayChargeDAO.deleteExtraDayCharge(id);
    }

    public void updateExtraDayCharge(Extradaycharge extradaycharge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Extradaycharge> getAllExtradaycharges() {
        return extraDayChargeDAO.getAllExtradaycharges();
    }

    public Extradaycharge searchExtradaycharge(Integer cId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
