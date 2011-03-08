package com.tanyajava.controller;

import com.tanyajava.ui.form.SignupForm;
import com.tanyajava.model.User;
import com.tanyajava.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.social.web.signin.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public SignupForm signupForm() {
        return new SignupForm();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Valid SignupForm form, BindingResult result, WebRequest request) {
        if (result.hasErrors()) {
            return null;
        }
        boolean accountCreated = createAccount(form, result);
        if (accountCreated) {
            ProviderSignInUtils.handleConnectPostSignUp(form.getUsername(), request);
            return "redirect:/";
        }
        return null;
    }

    // internal helpers
    private boolean createAccount(SignupForm form, BindingResult formBinding) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setUsername(form.getUsername());
        userService.save(user);
        return true;

    }
}
