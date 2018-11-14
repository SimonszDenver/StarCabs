/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.Packages;
import lk.ijse.starcabs.model.Vehicletype;
import lk.ijse.starcabs.service.PackageService;
import lk.ijse.starcabs.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Controller
public class PackageController {

    @Autowired
    PackageService packageService;
    @Autowired
    VehicleTypeService vehicleTypeService;

        @RequestMapping(value = "/searchPackages", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Packages> getSubjectFromLevel(@RequestParam("vTypeId") String vTypeId) {
        Packages packages = new Packages();
        System.out.println("VT ID IDI IDD : " + vTypeId);
        packages.setVehicleTypeID(new Vehicletype(Integer.parseInt(vTypeId)));
        List<Packages> searchPackages = packageService.searchPackagesByVehicleTypeId(packages);
        System.out.println("sPs : "+searchPackages.toString());
        return  searchPackages;
        

    }
    
    @RequestMapping(value = "/newPackages", method = RequestMethod.GET)
    public ModelAndView getAddPackagePage(ModelAndView modelAndView) {

        List<Vehicletype> allVehicleTypes = vehicleTypeService.getAllVehicleTypes();

        modelAndView.addObject("PackageDTO", new Packages());
        modelAndView.addObject("VehicleTypeList", allVehicleTypes);

        modelAndView.setViewName("AddPackages");
        return modelAndView;
    }

    @RequestMapping(value = "/newPackages", method = RequestMethod.POST)
    public String addPackages(@Valid Packages packages, BindingResult bindingResult) {

        packageService.addPackage(packages);
        return "redirect:/newPackages";
    }

//    @Autowired
//    PackageService packageService;


@RequestMapping(value = "/allpck", method = RequestMethod.GET)
    public ModelAndView getAllDrivers(ModelAndView modelAndView){
        List<Packages> listPackages = packageService.getAllPackages();
//        List<Driver> listDriver = driverService.getAllDrivers();
        modelAndView.addObject("listPackage", listPackages);
        modelAndView.setViewName("deletePackages");

        return modelAndView;
    }

    @RequestMapping(value = "/delete-{packageID}-packages", method = RequestMethod.GET)
    public String deleteDriver(@PathVariable("packageID") Integer pID) {
        packageService.deletePackage(pID);
//        driverService.deleteDriver(dID);
        return "redirect:/allpck";
    }
    
    
    @RequestMapping(value = "/search-{packageID}-packages", method = RequestMethod.GET)
    public ModelAndView searchCustomer(@PathVariable("packageID") Integer packageID, ModelAndView modelAndView) {
        Packages packages = packageService.searchPackage(packageID);
        modelAndView.addObject("PackageDTO", packages);
        modelAndView.setViewName("updatePackages");
        return modelAndView;

    }

    @RequestMapping(value = "/search-{packageID}-packages", method = RequestMethod.POST)
    public String updateCustomer(@Valid Packages packages, ModelMap modelMap) {
        System.out.println(""+packages);
//        System.out.println(customer.getFristName());
//        modelMap.put("success", "successMsg");
//        customerService.updateCustomer(customer);
        packageService.updatePackage(packages);
        return "redirect:/allpck";
    }

}
