/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanyajava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ifnu
 */
@Controller
public class SupportController {
    
    @RequestMapping(value="/support")
    public String support(){
        
        return "/support";
    }
}
