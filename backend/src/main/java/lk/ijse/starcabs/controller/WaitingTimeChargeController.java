/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.Vehicletype;
import lk.ijse.starcabs.model.Waitingtimecharge;
import lk.ijse.starcabs.service.VehicleTypeService;
import lk.ijse.starcabs.service.WaitingTimeChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Controller
public class WaitingTimeChargeController {
    @Autowired
    WaitingTimeChargeService waitingTimeChargeService;
    @Autowired
    VehicleTypeService vehicleTypeService;
    
    @RequestMapping(value = "/newwaitingtime", method = RequestMethod.GET)
    public ModelAndView getAddExtraDayChargePage(ModelAndView modelAndView) {
        List<Vehicletype> allVehicleTypes = vehicleTypeService.getAllVehicleTypes();

        modelAndView.addObject("WaitingTimeChargeDTO", new Waitingtimecharge());
        modelAndView.addObject("VehicleTypeList", allVehicleTypes);
        modelAndView.setViewName("addWaitingTimeCharge");
        return modelAndView;
    }

    @RequestMapping(value = "/newwaitingtime", method = RequestMethod.POST)
    public String addExtraDayCharge(@Valid Waitingtimecharge waitingtimecharge, BindingResult bindingResult) {

        waitingTimeChargeService.addWaitingtimecharge(waitingtimecharge);

        return "redirect:/newwaitingtime";
    }
}
