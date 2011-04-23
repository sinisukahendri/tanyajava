/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.controller;

import com.tanyajava.model.Question;
import com.tanyajava.model.Tag;
import com.tanyajava.model.User;
import com.tanyajava.service.MasterService;
import com.tanyajava.service.QuestionService;
import com.tanyajava.service.UserService;
import com.tanyajava.ui.form.QuestionForm;
import com.tanyajava.utils.UrlUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired private UserService userService;

    @RequestMapping(value="/ask",method=RequestMethod.GET)
    public String ask(Model model){
        model.addAttribute("question",new QuestionForm());
        return "/ask";
    }
    
    @RequestMapping(value="/ask",method=RequestMethod.POST)
    public String ask(@Valid @ModelAttribute("question") QuestionForm questionForm,
        BindingResult result,
        Model model){
        //check if user already loged in or not
        if(!validate(questionForm, result)){
            return "/ask";
        }
        User u = createUser(questionForm);
        Question q = createQuestion(questionForm,u);
        questionService.save(q);
        return "redirect:/index";
    }
    
    private boolean validate(QuestionForm questionForm, BindingResult result){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth instanceof AnonymousAuthenticationToken){
            //check for username and email
            if(!StringUtils.hasText(questionForm.getUserName())){
                result.addError(new FieldError("question","userName", "silahkan isi username"));
            } 
            if(!StringUtils.hasText(questionForm.getEmail())){
                result.addError(new FieldError("question","email", "silahkan isi email"));
            }
            if(result.hasErrors()){
                return false;
            }
        }
        return true;
    }
    
    @RequestMapping(value="/q/{id}/{url}",method=RequestMethod.GET)
    public String q(@PathVariable(value="id") Long id,
            @PathVariable(value="url")String url, Model model){
        Question q = questionService.getQuestion(id);
        model.addAttribute("question",q);
        return "/question";
    }


    private User createUser(QuestionForm questionForm){
        User u = userService.getUserByEmail(questionForm.getEmail());
        if(u == null){
            u = new User();
            u.setUsername(questionForm.getUserName());
            u.setEmail(questionForm.getEmail());
        }
        return u;
    }

    private Question createQuestion(QuestionForm questionForm, User user){
        Question q = new Question();
        q.setAnswered(false);
        q.setCreatedDate(new Date());
        q.setQuestion(questionForm.getQuestion());
        q.setTitle(questionForm.getTitle());
        q.setUrl(UrlUtils.createFriendlyUrl(q.getTitle()));
        q.setUser(user);
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
