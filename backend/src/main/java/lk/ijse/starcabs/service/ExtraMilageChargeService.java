/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service;

import lk.ijse.starcabs.model.Extramileagecharge;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface ExtraMilageChargeService {

    void addExtramileagecharge(Extramileagecharge extramileagecharge);

    void deleteExtramileagecharge(int id);

    void updateExtramileagecharge(Extramileagecharge extramileagecharge);

    List<Extramileagecharge> getAllExtramileagecharges();

    public Extramileagecharge searchExtramileagecharge(Integer cId);
}
