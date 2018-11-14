/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.*;
import lk.ijse.starcabs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
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
@SessionAttributes({"OrdersDTO","logedCustomer"})
public class OrdersController {

    @Autowired
    OrderService orderService;
    @Autowired
    CustomerService customerService;
    @Autowired
    PackageService packageService;
    @Autowired
    Locationservice locationservice;
    @Autowired
    VehicleTypeService vehicleTypeService;
    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public ModelAndView getAddCustomerPage(ModelAndView modelAndView, @ModelAttribute("logedCustomer") Customer customer) {
        System.out.println(customer.getAddress()+customer.getFristName());
        if (customer.getFristName()==null) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        } else {
            List<District> allDistrict = locationservice.getAllDistrict();
            List<Vehicletype> allVehicleTypes = vehicleTypeService.getAllVehicleTypes();
            Orders orders = new Orders();
        //modelAndView.addObject("allCustomers", allCustomers);
            //   modelAndView.addObject("allPackages", allPackages);
            modelAndView.addObject("OrdersDTO", orders);
            //modelAndView.addObject("loginTest", login);
            modelAndView.addObject("allDistrict", allDistrict);
            modelAndView.addObject("allVehicleTypes", allVehicleTypes);
            modelAndView.setViewName("newOrder");
            return modelAndView;
        }

    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public String addOrders(@Valid @ModelAttribute("OrdersDTO") Orders orders, ModelMap modelMap, BindingResult result) {
       // System.out.println("XXXXXXXXXX______________XXXXXXXXXXXXX");
//        System.out.println("C_ID : " + customer.getCustomerID());
//        System.out.println("F_NAME : " + customer.getFristName());

        if (result.hasErrors()) {
            return "newOrder";
        }
        String curTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        orders.setOrderDate(new Date());
        orders.setTimes(curTime);

        modelMap.put("success", "successMsg");
        System.out.println("ZZZZZZZZZ--------- : " + orders.getOrderdetailsList().size() + "-----ZZZZZZZZZ");
        orderService.addOrder(orders);
        return "newOrder";

    }

    @RequestMapping(value = "/addOrderDetailToOrder", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Orders addToExamList(@RequestParam Map<String, String> reqPar, @ModelAttribute("OrdersDTO") Orders orders) {
        Orderdetails orderdetails = new Orderdetails();
        System.out.println("ADD ORDERDETAIL TO ORDER RUN__________))__)+");
        //data: {discount: discount, arrivalDate: arrivalDate, dipatureDate: dipatureDate, time1: time1, time2: time1, packages: packageId,vehicle: vehicleId},
        //origin: origin, destination: destination
        double discount = 0.0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
        Date dipatureDate = null;
        Date arrivalDate = null;
        try {
            dipatureDate = dateFormat.parse(reqPar.get("dipatureDate"));
            arrivalDate = dateFormat2.parse(reqPar.get("arrivalDate"));
        } catch (ParseException ex) {
            Logger.getLogger(VehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String time1 = reqPar.get("time1") + ":00";
        String time2 = reqPar.get("time2");
        String packages = reqPar.get("packages");
        String vehicle = reqPar.get("vehicle");
        String origin = reqPar.get("origin");
        String destination = reqPar.get("destination");
        System.out.println("==============================");
        System.out.println(discount + " : " + arrivalDate + " : " + dipatureDate + "time1 : " + time1 + " !!time2 : " + time2 + " !!package : " + packages + " : " + vehicle + " : " + origin + " : " + destination);
        System.out.println("----------------------=-=-=----------");

        Packages searchPackage = packageService.searchPackage(Integer.parseInt(packages));
        Vehicle searchVehicle = vehicleService.searchVehicle(Integer.parseInt(vehicle));
        orderdetails.setDiscount(BigDecimal.valueOf(discount));
        orderdetails.setArrivalDate(arrivalDate);
        orderdetails.setDipatureDate(dipatureDate);
        orderdetails.setTime1(time1);
        orderdetails.setTime2(time2);
        orderdetails.setPackages(searchPackage);
        orderdetails.setVehicle(searchVehicle);
        orderdetails.setOrigin(origin);
        orderdetails.setDestination(destination);
        orderdetails.setOrders(orders);

        System.out.println(orderdetails.getDipatureDate() + " : " + orderdetails.getArrivalDate() + " : " + orderdetails.getTime1() + " : ");

        System.out.println("========== OrderDetailList Size : " + orders.getOrderdetailsList().size());
        orders.getOrderdetailsList().add(orderdetails);
        System.out.println("========== OrderDetailList Size AFTER ADDING: " + orders.getOrderdetailsList().size());
        return orders;

    }

    @RequestMapping(value = "/allord", method = RequestMethod.GET)
    public ModelAndView getAllOrders(ModelAndView modelAndView){
//        List<Orderdetails> listDriver = driverService.getAllDrivers();
        List<Orders> listOrderdetails = orderService.getAllOrders();
        List<Packages> listPackages = packageService.getAllPackages();
        List<Vehicle> listVehicles = vehicleService.getAllVehicles();
        modelAndView.addObject("listOrderdetails", listOrderdetails);
//modelAndView.addAllObjects(Map<"listOrderdetails","listPackages">);
        modelAndView.setViewName("deleteOrderDetail");

        return modelAndView;
    }
//
//    @RequestMapping(value = "/delete-{packageID}-driver", method = RequestMethod.GET)
//    public String deleteDriver(@PathVariable("driverID") Integer dId) {
//        driverService.deleteDriver(dId);
//        return "redirect:/alldri";
//    }

}
