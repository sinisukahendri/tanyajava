/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.controller;

import com.tanyajava.model.Question;
import com.tanyajava.model.Tag;
import com.tanyajava.service.MasterService;
import com.tanyajava.service.QuestionService;
import com.tanyajava.ui.form.QuestionForm;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired private QuestionService questionService;
    @Autowired private MasterService masterService;

    @RequestMapping(value="/ask",method=RequestMethod.GET)
    public ModelAndView askQuestion(){
        ModelAndView m = new ModelAndView();
        m.addObject("question",new QuestionForm());
        return m;
    }

    @RequestMapping(value="/ask",method=RequestMethod.POST)
    public ModelAndView askQuestion(QuestionForm questionForm){

        Question question = new Question();
        BeanUtils.copyProperties(questionForm, question);
        //tag
        List<Tag> tagList = masterService.save(questionForm.getTags());
        question.setTags(tagList);
        questionService.save(question);
        ModelAndView m = new ModelAndView();
        m.addObject("question", masterService);
        return m;
    }


}
