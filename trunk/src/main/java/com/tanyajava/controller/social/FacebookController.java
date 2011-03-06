/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanyajava.controller.social;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.FacebookApi;
import org.springframework.social.facebook.FacebookProfile;
import org.springframework.social.facebook.connect.FacebookServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu
 */
@Controller
public class FacebookController {

    @Autowired
    private FacebookServiceProvider facebookProvider;

    @RequestMapping(value = "/facebook", method = RequestMethod.GET)
    public String home(Principal currentUser, Model model) {
        if (facebookProvider.isConnected(currentUser.getName())) {
            FacebookProfile userProfile = getFacebookApi(currentUser).getUserProfile();
            model.addAttribute("facebookUser", userProfile);
            return "facebook/facebook";
        }
        return "redirect:/connect/facebook";
    }

    @RequestMapping(value = "/facebook/wall", method = RequestMethod.POST)
    public String postToWall(Principal currentUser, String message) {
        getFacebookApi(currentUser).updateStatus(message);
        return "redirect:/facebook";
    }

    private FacebookApi getFacebookApi(Principal user) {
        return facebookProvider.getConnections(user.getName()).get(0).getServiceApi();
    }
}
