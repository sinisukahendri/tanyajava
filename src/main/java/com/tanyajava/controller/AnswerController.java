/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.controller;

import com.tanyajava.model.Question;
import com.tanyajava.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu
 */
@Controller
public class AnswerController {

    @Autowired private QuestionService questionService;

    @RequestMapping(value="/answer/{id}",method=RequestMethod.GET)
    public String answer(@PathVariable Long id, Model model){
        Question q = questionService.getQuestion(id);
        model.addAttribute(q);
        //check if user already login or not
        Boolean login = System.currentTimeMillis() % 2 == 0 ? Boolean.TRUE : Boolean.FALSE;
        model.addAttribute("login", login);
        return "/answer";
    }

}
