/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.Extramileagecharge;
import lk.ijse.starcabs.model.Vehicletype;
import lk.ijse.starcabs.service.ExtraMilageChargeService;
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
 * @author STARFLOWER
 */
@Controller
public class ExtraMileageChargeController {
    @Autowired
    VehicleTypeService vehicleTypeService;
    @Autowired
    ExtraMilageChargeService extraMilageChargeService;

    @RequestMapping(value = "/newextramileage", method = RequestMethod.GET)
    public ModelAndView getAddExtraMileageChargePage(ModelAndView modelAndView) {
        List<Vehicletype> allVehicleTypes = vehicleTypeService.getAllVehicleTypes();

        modelAndView.addObject("ExtraMileageChargeDTO", new Extramileagecharge());
        modelAndView.addObject("VehicleTypeList", allVehicleTypes);
        modelAndView.setViewName("addExtraMileageCharge");
        return modelAndView;
    }

    @RequestMapping(value = "/newextramileage", method = RequestMethod.POST)
    public String addExtraMileageCharge(@Valid Extramileagecharge extramileagecharge, BindingResult bindingResult) {

        extraMilageChargeService.addExtramileagecharge(extramileagecharge);

        return "redirect:/newextramileage";
    }

    @RequestMapping(value = "/allemc", method = RequestMethod.GET)
    public ModelAndView getAllExtraMileageCharge(ModelAndView modelAndView) {
//        List<Driver> listDriver = driverService.getAllDrivers();
//        List<Vehicle> listVehicle = vehicleService.getAllVehicles();
        List<Extramileagecharge> listExtraMileageCharge = extraMilageChargeService.getAllExtramileagecharges();
        modelAndView.addObject("listVehicle", listExtraMileageCharge);
        modelAndView.setViewName("deleteExtraMileageCharge");

        return modelAndView;
    }

    @RequestMapping(value = "/delete-{extraMileageChargeID}-extramileagecharge", method = RequestMethod.GET)
    public String deleteExtraMileageCharge(@PathVariable("extraMileageChargeID") Integer vID) {
//        vehicleService.deleteVehicle(vID);
//        driverService.deleteDriver(vID);
        extraMilageChargeService.deleteExtramileagecharge(vID);
        return "redirect:/allemc";
    }

}
