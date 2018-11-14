/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.Vehicletype;
import lk.ijse.starcabs.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author STARFLOWER
 */

@Controller
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    @RequestMapping(value = "/vtnew", method = RequestMethod.GET)
    public ModelAndView getAddVehicleTypePage(ModelAndView modelAndView) {

        modelAndView.addObject("VehicleTypeDTO", new Vehicletype());
        modelAndView.setViewName("newVehicleType");
        return modelAndView;
    }

    @RequestMapping(value = "/vtnew", method = RequestMethod.POST)
    public String addCustomer(@Valid Vehicletype vehicletype, ModelMap modelMap) {

        modelMap.put("success", "successMsg");
        vehicleTypeService.addVehicleType(vehicletype);
        return "redirect:/vtnew";
    }

    @RequestMapping(value = "/allvt", method = RequestMethod.GET)
    public ModelAndView getAllCustomers(ModelAndView modelAndView) throws ArrayIndexOutOfBoundsException, SQLException, ClassNotFoundException, IOException {
        List<Vehicletype> listTypes = vehicleTypeService.getAllVehicleTypes();
        modelAndView.addObject("listTypes", listTypes);
        modelAndView.setViewName("");

        return modelAndView;
    }

    @RequestMapping(value = "/xxx", method = RequestMethod.GET)
    public String checkAjaxTest() {

        return "typeAjax";
    }

//    @RequestMapping(value = "addVType/{tName}/{fType}", method = RequestMethod.GET)
//    public @ResponseBody
//    String addVehicleType(@PathVariable("tName") String tName, @PathVariable("fType") String fType) {
//
//        System.out.println("FUCK 1");
//        Vehicletype vehicletype = new Vehicletype();
//        vehicletype.setFuelType(fType);
//        vehicletype.setTypeName(tName);
//
//        Gson gson = new Gson();
//        return gson.toJson(vehicletype);
//
//    }

    //@ResponseBody gets required conversion type by looking at produces={"application/json"}
    //@ResponseBody annotation needs JACKSON librarys for convertion
    //JACKSON librays depends on Spring Version
    //Do not use latest JACKSON librarys for old spring versions

    @RequestMapping(value = "/location", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public Vehicletype getLocationFromCountry(@RequestParam("fType") String fType,
            @RequestParam("tName") String tName) {
        //getting List containing Location objects from LocationService
        //by parsing country parameter
        System.err.println("methodweda");
        System.err.println("methodweda :  " + fType + " :  " + tName);
        Vehicletype vehicletype = new Vehicletype();
        vehicletype.setFuelType(fType);
        vehicletype.setTypeName(tName);
        return vehicletype;
    }

}
