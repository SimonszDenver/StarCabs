/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.starcabs.controller;

import lk.ijse.starcabs.model.Packages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author STARFLOWER
 */

@Controller
public class TestController {
    
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public ModelAndView getAddCustomerPage(ModelAndView modelAndView) {

        List<Packages> packages = new ArrayList<Packages>();
        modelAndView.addObject("packages", packages);
        modelAndView.setViewName("tableTest");
        return modelAndView;
    }
}
