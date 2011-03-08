/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.controller;

import com.tanyajava.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu
 */
@Controller
public class IndexController {

    @Autowired private QuestionService questionService;

    @RequestMapping(value="/index",method=RequestMethod.GET)
    public Model index(Model model){

        //most viewed question today
        //search
        //tag cloud
        //new badge user
        //trending
        model.addAttribute("questionList", questionService.getQuestion(0, 20));
        return model;
    }

}
