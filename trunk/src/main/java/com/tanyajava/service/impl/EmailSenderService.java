/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class EmailSenderService{

    @Autowired MailSender mailSender;
    @Autowired SimpleMailMessage mailMessage;

    public void sendDownloadEmail(String email,String id){
        
    }

}
