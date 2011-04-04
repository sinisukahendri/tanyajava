/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanyajava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu
 */
@Controller
public class ContactController {
 @RequestMapping(value="/contact",method= RequestMethod.GET)
    public String contact(Model model){
        return "/contact";
    }   
}
