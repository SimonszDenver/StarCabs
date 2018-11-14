/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.Driver;
import lk.ijse.starcabs.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class DriverController {
    @Autowired
    DriverService driverService;

        @RequestMapping(value = "/drivernew", method = RequestMethod.GET)
    public ModelAndView getAddDriverPage(ModelAndView modelAndView) {

        modelAndView.addObject("DriverDTO", new Driver());
        modelAndView.setViewName("addDriver");
        return modelAndView;
    }
        @RequestMapping(value = "/drivernew", method = RequestMethod.POST)
    public String addDriver(@Valid Driver driver, BindingResult bindingResult) {

//        packageService.addPackage(packages);
        driverService.addDriver(driver);
        return "redirect:/drivernew";
    }



    @RequestMapping(value = "/search-{dId}-driver", method = RequestMethod.GET)
    public ModelAndView searchDriver(@PathVariable("dId") Integer dId, ModelAndView modelAndView){
        Driver driver = driverService.searchDriver(dId);
        modelAndView.addObject("DriverDTO", driver);
        modelAndView.setViewName("updateDriver");
        return modelAndView;

    }

    @RequestMapping(value = "/dnew", method = RequestMethod.POST)
    public String addDriver(@Valid Driver driver, ModelMap modelMap) {

        modelMap.put("success", "successMsg");
        driverService.addDriver(driver);
        return "redirect:/dnew";
    }

    @RequestMapping(value = "/search-{driverID}-driver", method = RequestMethod.POST)
    public String updateDriver(@Valid Driver driver, ModelMap modelMap) {
//        modelMap.put("success", "successMsg");
        driverService.updateDriver(driver);
        return "redirect:/alldri";
    }

    @RequestMapping(value = "/alldri", method = RequestMethod.GET)
    public ModelAndView getAllDrivers(ModelAndView modelAndView){
        List<Driver> listDriver = driverService.getAllDrivers();
        modelAndView.addObject("listDriver", listDriver);
        modelAndView.setViewName("deleteDriver");

        return modelAndView;
    }

    @RequestMapping(value = "/delete-{driverID}-driver", method = RequestMethod.GET)
    public String deleteDriver(@PathVariable("driverID") Integer dId) {
        driverService.deleteDriver(dId);
        return "redirect:/alldri";
    }

    @RequestMapping(value = "/edit-{driverID}-driverID", method = RequestMethod.GET)
    public String editDriver(@PathVariable("driverID") Integer dId, ModelMap modelMap) {
        Driver driver = driverService.searchDriver(dId);
        modelMap.addAttribute("Driver", driver);
        modelMap.addAttribute("edit", true);
        return "output";

    }
//    search-${dri.driverID}-driver
        @RequestMapping(value = "/search-{driverID}-driver", method = RequestMethod.GET)
//    public ModelAndView searchDriver(@PathVariable("driverID") Integer driverID, ModelAndView modelAndView) {
        public ModelAndView searchDriver1(@PathVariable("driverID") Integer driverID, ModelAndView modelAndView) {
        Driver driver = driverService.searchDriver(driverID);
        modelAndView.addObject("DriverDTOo", driver);
        modelAndView.setViewName("updateDriver");
        return modelAndView;

    }
}
