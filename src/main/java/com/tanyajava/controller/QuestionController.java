/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.controller;

import com.tanyajava.ui.form.QuestionForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ifnu
 */
@Controller
public class QuestionController {

    @RequestMapping(value="/ask",method=RequestMethod.GET)
    public ModelAndView askQuestion(){
        ModelAndView m = new ModelAndView();
        m.addObject(new QuestionForm());
        return m;
    }

    @RequestMapping(value="/ask",method=RequestMethod.POST)
    public ModelAndView askQuestion(QuestionForm questionForm){
        
        ModelAndView m = new ModelAndView();
        return m;
    }


}
