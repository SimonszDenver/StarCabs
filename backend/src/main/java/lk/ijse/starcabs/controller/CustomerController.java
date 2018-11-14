/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.Customer;
import lk.ijse.starcabs.model.Login;
import lk.ijse.starcabs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author STARFLOWER
 */
@Controller
@SessionAttributes("logedCustomer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customernew", method = RequestMethod.GET)
    public ModelAndView getAddCustomerPage(ModelAndView modelAndView) {

        Customer customer = new Customer();
        modelAndView.addObject("CustomerDTO", customer);
        modelAndView.setViewName("newCustomer");
        return modelAndView;
    }
    @RequestMapping(value = "/customerHome", method = RequestMethod.GET)
    public String getCustomerHome() {
        return "customerHome";
    }
    @RequestMapping(value = "/gallery", method = RequestMethod.GET)
    public String getGallery() {
        return "Gallery";
    }
    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String getAboutUs() {
        return "aboutUs";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getContact() {
        return "contact";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logOutCustomer(@ModelAttribute("logedCustomer") Customer customer,ModelAndView modelAndView) {
        //Customer cus = new Customer();
        customer=new Customer();
    //    HttpSession session = 
        modelAndView.addObject("logedCustomer", customer);
        modelAndView.setViewName("customerHome_1");
        return modelAndView;
    }

    @RequestMapping(value = "/customernew", method = RequestMethod.POST)
    public String addCustomer(@Valid Customer customer, ModelMap modelMap) {
        Login login = new Login();
        login.setUserName(customer.getUserName());
        login.setPassword(customer.getPassword());
        System.out.println("SAVE CUSTOMER PASSWORD : ======"+customer.getPassword());
        modelMap.put("login", login);
        modelMap.put("success", "successMsg");
        customerService.addCustomer(customer);
        return "redirect:/login";
    }

    @RequestMapping(value = "/search-{cId}-customer", method = RequestMethod.GET)
    public ModelAndView searchCustomer(@PathVariable("cId") Integer cId, ModelAndView modelAndView) {
        Customer customer = customerService.searchCustomer(cId);
        modelAndView.addObject("CustDTO", customer);
        modelAndView.setViewName("updateCustomer");
        return modelAndView;

    }

    @RequestMapping(value = "/search-{cId}-customer", method = RequestMethod.POST)
    public String updateCustomer(@Valid Customer customer, ModelMap modelMap) {
        System.out.println(""+customer);
        System.out.println(customer.getFristName());
//        modelMap.put("success", "successMsg");
        customerService.updateCustomer(customer);
        return "redirect:/allcus";
    }

    @RequestMapping(value = "/allcus", method = RequestMethod.GET)
    public ModelAndView getAllCustomers(ModelAndView modelAndView) {
        
            List<Customer> listCustomer = customerService.getAllCustomers();
            modelAndView.addObject("listCustomer", listCustomer);
            modelAndView.setViewName("deleteCustomer");
            
            
        
            return modelAndView;
        
    }

    @RequestMapping(value = "/delete-{customerID}-customer", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable("customerID") Integer cId){
        customerService.deleteCustomer(cId);
        return "redirect:/allcus";
    }

    @RequestMapping(value = "/edit-{cId}-customer", method = RequestMethod.GET)
    public String editCustomer(@PathVariable("customerID") Integer cId, ModelMap modelMap)  {
        Customer customer = customerService.searchCustomer(cId);
        modelMap.addAttribute("Customer", customer);
        modelMap.addAttribute("edit", true);
        return "output";

    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView gelLoging(ModelAndView modelAndView) {

        Login login=new Login();
        Customer customer = new Customer();
        modelAndView.addObject("login", login);
        modelAndView.addObject("logedCustomer", customer);
        
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginProcess(@Valid @ModelAttribute("login") Login login, BindingResult result,
            ModelMap map, @ModelAttribute("logedCustomer") Customer customer) {
        if (result.hasErrors()) {
            HashMap<String, String> errors = new HashMap<String, String>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            map.put("errors", errors);
            return "login";
        }
        System.err.println("loginnnn  :  "+login.getPassword()+"   :   "+login.getUserName());
        boolean checkUsernamePassword = customerService.checkUsernamePassword(login.getUserName(), login.getPassword());
        System.out.println(checkUsernamePassword);
        if (checkUsernamePassword) {
            customer = customerService.searchCustomerByUserName(login.getUserName());
            System.out.println("C_ID : "+customer.getCustomerID());
            System.out.println("F_NAME : "+customer.getFristName());
            map.addAttribute("logedCustomer", customer);
            map.addAttribute("logined", login);
          
            return "customerHome";
        } else {
            map.put("error", "Invalid User Name Or Password");
            return "login";
        }
    }

}
