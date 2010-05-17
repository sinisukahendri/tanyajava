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
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public ModelAndView askQuestion(HttpServletRequest request,
            @ModelAttribute("question") QuestionForm questionForm){

        Question question = new Question();
        BeanUtils.copyProperties(questionForm, question);
        //tag
        List<Tag> tagList = masterService.save(questionForm.getTagString());
        question.setTags(tagList);
        questionService.save(question);
        ModelAndView m = new ModelAndView(new RedirectView("/j/q/" + question.getUrl()));
        return m;
    }
    
    @RequestMapping(value="/q/{url}",method=RequestMethod.GET)
    public ModelAndView getQuestion(@PathVariable("url") String url){

        Question question = questionService.getQuestionByUrl(url);
        ModelAndView m = new ModelAndView("question");
        m.addObject("question", question);
        return m;
    }


}
