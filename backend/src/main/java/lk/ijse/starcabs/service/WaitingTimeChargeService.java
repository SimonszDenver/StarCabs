/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.service;

import lk.ijse.starcabs.model.Waitingtimecharge;

import java.util.List;

/**
 *
 * @author STARFLOWER
 */
public interface WaitingTimeChargeService {

    void addWaitingtimecharge(Waitingtimecharge waitingtimecharge);

    void deleteWaitingtimecharge(int id);

    void updateWaitingtimecharge(Waitingtimecharge waitingtimecharge);

    List<Waitingtimecharge> getAllWaitingtimecharges();

    public Waitingtimecharge searchWaitingtimecharge(Integer cId);
}
