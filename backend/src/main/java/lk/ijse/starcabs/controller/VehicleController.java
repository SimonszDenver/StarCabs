/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.District;
import lk.ijse.starcabs.model.Orderdetails;
import lk.ijse.starcabs.model.Vehicle;
import lk.ijse.starcabs.model.Vehicletype;
import lk.ijse.starcabs.service.Locationservice;
import lk.ijse.starcabs.service.VehicleService;
import lk.ijse.starcabs.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STARFLOWER
 */

@Controller
public class VehicleController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    @Autowired
    VehicleService vehicleService;
    
    @Autowired
    Locationservice locationservice;
    
    @RequestMapping(value = "/vnew", method = RequestMethod.GET)
    public ModelAndView getAddVehiclePage(ModelAndView modelAndView) {
        List<Vehicletype> allVehicleTypes = vehicleTypeService.getAllVehicleTypes();
        List<District> allDistrict = locationservice.getAllDistrict();
        modelAndView.addObject("VehicleDTO", new Vehicle());
        modelAndView.addObject("VehicleTypeList", allVehicleTypes);
        modelAndView.addObject("allDistrict", allDistrict);
        modelAndView.setViewName("AddVehicle");
        return modelAndView;
    }

    @RequestMapping(value = "/vnew", method = RequestMethod.POST)
    public String addVehicle(@Valid Vehicle vehicle,  BindingResult bindingResult) {
        vehicleService.addVehicle(vehicle);
        return "redirect:/vnew";
    }
    
    @RequestMapping(value = "/searchVehicles", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Vehicle> searchVehicles(@RequestParam("vTypeId") String vTypeId) {
        Vehicle vehicle = new Vehicle();
        System.out.println("VT ID IDI IDD : " + vTypeId);
        vehicle.setVehicleTypeID(new Vehicletype(Integer.parseInt(vTypeId)));
        List<Vehicle> searchVehicles = vehicleService.searchVehiclebyVehicleTypeId(vehicle);
        System.out.println("SEARCH : "+searchVehicles.toString());
        return  searchVehicles;
        

    }
    @RequestMapping(value = "/searchAvailableVehicles", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Vehicle> getSearchAvailableVehicles(@RequestParam Map<String, String> reqPar) {
        //data: {vTypeId: fType, date1: date, date2: date2, time1: time, time2: time2},
        System.out.println("-----=--=-=-=-=-=-=-=-=-=-=-=*************");
        int vTypeId = Integer.parseInt(reqPar.get("vTypeId"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
        Date parse1 = null;
        Date parse2 = null;
        try {
            parse1 = dateFormat.parse(reqPar.get("date1"));
            parse2 = dateFormat2.parse(reqPar.get("date2"));
            System.out.println("date date");
        } catch (ParseException ex) {
            Logger.getLogger(VehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String date1 = dateFormat.format(parse1);
        String date2 = dateFormat.format(parse2);
        Orderdetails orderdetails = new Orderdetails();
        orderdetails.setDipatureDate(parse1);
        orderdetails.setArrivalDate(parse2);
        orderdetails.setTime1(date1);
        orderdetails.setTime2(date2);
        
        orderdetails.setVehicle(new Vehicle());
        orderdetails.getVehicle().setVehicleTypeID(new Vehicletype(vTypeId));
        orderdetails.getVehicle().setDistrict(reqPar.get("location"));
        
        
        System.out.println("-----=--=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" vType : "+orderdetails.getVehicle().getVehicleTypeID().getVehicleTypeID()
        +" date 01 : "+orderdetails.getArrivalDate()+" date 02 : "+orderdetails.getDipatureDate());
        List<Vehicle> searchAvailableVehicle = vehicleService.searchAvailableVehicle(orderdetails);
        for (Vehicle searchAvailableVehicle1 : searchAvailableVehicle) {
            System.out.println(searchAvailableVehicle1.getRegNo());
        }
        return  searchAvailableVehicle;

    }
    
    
    @RequestMapping(value = "/allveh", method = RequestMethod.GET)
    public ModelAndView getAllVehicles(ModelAndView modelAndView){
//        List<Driver> listDriver = driverService.getAllDrivers();
        List<Vehicle> listVehicle = vehicleService.getAllVehicles();
        modelAndView.addObject("listVehicle", listVehicle);
        modelAndView.setViewName("deleteVehicle");

        return modelAndView;
    }

    @RequestMapping(value = "/delete-{vehicleID}-vehicle", method = RequestMethod.GET)
    public String deleteVehicle(@PathVariable("vehicleID") Integer vID) {
        vehicleService.deleteVehicle(vID);
//        driverService.deleteDriver(vID);
        return "redirect:/allveh";
    }
    
}
