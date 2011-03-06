/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanyajava.controller.social;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ServiceProviderConnection;
import org.springframework.social.twitter.TwitterApi;
import org.springframework.social.twitter.TwitterProfile;
import org.springframework.social.twitter.connect.TwitterServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu
 */
@Controller
public class TwitterController {

    @Autowired
    private TwitterServiceProvider twitterProvider;

    @RequestMapping(value = "/twitter", method = RequestMethod.GET)
    public String home(Principal currentUser, Model model) {
        List<ServiceProviderConnection<TwitterApi>> connections = twitterProvider.getConnections(currentUser.getName());
        if (connections.size() > 0) {
            List<TwitterProfile> connectedProfiles = new ArrayList<TwitterProfile>(connections.size());
            for (ServiceProviderConnection<TwitterApi> connection : connections) {
                connectedProfiles.add(connection.getServiceApi().getUserProfile());
            }
            model.addAttribute("connectedProfiles", connectedProfiles);
            model.addAttribute(new TweetForm());
            return "twitter/twitter";
        }
        return "redirect:/connect/twitter";
    }

    @RequestMapping(value = "/twitter/tweet", method = RequestMethod.POST)
    public String postTweet(Principal currentUser, TweetForm tweetForm) {
        List<ServiceProviderConnection<TwitterApi>> connections = twitterProvider.getConnections(currentUser.getName());
        for (ServiceProviderConnection<TwitterApi> connection : connections) {
            TwitterApi twitter = connection.getServiceApi();
            if (tweetForm.isTweetToAll() || twitter.getProfileId().equals(tweetForm.getScreenName())) {
                twitter.updateStatus(tweetForm.getMessage());
            }
        }
        return "redirect:/twitter";
    }
}
