/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.dao;

import lk.ijse.starcabs.model.Extradaycharge;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface ExtraDayChargeDAO {

    void addExtraDayCharge(Extradaycharge extradaycharge);

    void deleteExtraDayCharge(int id);

    void updateExtraDayCharge(Extradaycharge extradaycharge);

    List<Extradaycharge> getAllExtradaycharges();

    public Extradaycharge searchExtradaycharge(Integer cId);
}
