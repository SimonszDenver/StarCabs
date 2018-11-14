/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.Extradaycharge;
import lk.ijse.starcabs.model.Vehicletype;
import lk.ijse.starcabs.service.ExtraDayChargeService;
import lk.ijse.starcabs.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ExtraDayChargeController {

    @Autowired
    VehicleTypeService vehicleTypeService;
    @Autowired
    ExtraDayChargeService extraDayChargeService;

    @RequestMapping(value = "/newextraday", method = RequestMethod.GET)
    public ModelAndView getAddExtraDayChargePage(ModelAndView modelAndView) {
        List<Vehicletype> allVehicleTypes = vehicleTypeService.getAllVehicleTypes();

        modelAndView.addObject("ExtraDayChargeDTO", new Extradaycharge());
        modelAndView.addObject("VehicleTypeList", allVehicleTypes);
        modelAndView.setViewName("addExtraDayCharge");
        return modelAndView;
    }

    @RequestMapping(value = "/newextraday", method = RequestMethod.POST)
    public String addExtraDayCharge(@Valid Extradaycharge extradaycharge, BindingResult bindingResult) {

        extraDayChargeService.addExtraDayCharge(extradaycharge);

        return "redirect:/newextraday";
    }
    
        @RequestMapping(value = "/alledc", method = RequestMethod.GET)
    public ModelAndView getAllExtraDayCharge(ModelAndView modelAndView){
//        List<Driver> listDriver = driverService.getAllDrivers();
        List<Extradaycharge> listExtraDayCharge = extraDayChargeService.getAllExtradaycharges();
        modelAndView.addObject("listExtraDayCharge", listExtraDayCharge);
        modelAndView.setViewName("deleteExtraDayCharge");

        return modelAndView;
    }

    @RequestMapping(value = "/delete-{extraDayChargeID}-extradaycharge", method = RequestMethod.GET)
    public String deleteExtraDayCharge(@PathVariable("extraDayChargeID") Integer edID) {
        extraDayChargeService.deleteExtraDayCharge(edID);
//        driverService.deleteDriver(dId);
        return "redirect:/alledc";
    }
}
