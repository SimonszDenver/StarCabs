/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service.impl;

import lk.ijse.starcabs.dao.ExtraMilageChargeDAO;
import lk.ijse.starcabs.model.Extramileagecharge;
import lk.ijse.starcabs.service.ExtraMilageChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Service
@Transactional
public class ExtraMileageChargeServiceImpl implements ExtraMilageChargeService {
    @Autowired
    ExtraMilageChargeDAO extraMilageChargeDAO;

    public void addExtramileagecharge(Extramileagecharge extramileagecharge) {
        extraMilageChargeDAO.addExtramileagecharge(extramileagecharge);
    }

    public void deleteExtramileagecharge(int id) {
        extraMilageChargeDAO.deleteExtramileagecharge(id);
    }

    public void updateExtramileagecharge(Extramileagecharge extramileagecharge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Extramileagecharge> getAllExtramileagecharges() {
        return extraMilageChargeDAO.getAllExtramileagecharges();
    }

    public Extramileagecharge searchExtramileagecharge(Integer cId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
