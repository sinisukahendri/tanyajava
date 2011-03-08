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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu
 */
@Controller
public class QuestionController {

    @Autowired private MasterService masterService;
    @Autowired private QuestionService questionService;

    @RequestMapping(value="/ask",method=RequestMethod.GET)
    public String askQuestion(Model model){
        model.addAttribute("question",new QuestionForm());
        return "/ask";
    }

    @RequestMapping(value="/ask",method=RequestMethod.POST)
    public String askQuestion(@Valid QuestionForm questionForm){
        Question q = createQuestion(questionForm);
        questionService.save(q);
        return "redirect:/index";
    }

    private Question createQuestion(QuestionForm questionForm){
        Question q = new Question();
        q.setAnswered(false);
        q.setCreatedDate(new Date());
        q.setQuestion(questionForm.getQuestion());
        if(StringUtils.hasText(questionForm.getTags())){
            String[] tags = questionForm.getTags().split(",");
            List<Tag> tagList = new ArrayList<Tag>();
            for (String tag : tags) {
                Tag t = masterService.getTag(tag);
                if(t!=null){
                    t.setAssigned(t.getAssigned() + 1);
                    masterService.save(t);
                    tagList.add(t);
                } else {
                    t = new Tag();
                    t.setName(tag);
                    t.setAssigned(1l);
                    t.setDateCreated(new Date());
                    masterService.save(t);
                    tagList.add(t);
                }
            }
            q.setTags(tagList);
        }
        return q;
    }


}
