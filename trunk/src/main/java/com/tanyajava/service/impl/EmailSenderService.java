/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.dao.DownloadItemDao;
import com.tanyajava.model.DownloadItem;
import java.io.StringWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
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

    @Autowired private MailSender mailSender;
    @Autowired private SimpleMailMessage mailMessage;
    @Autowired private VelocityEngine velocityEngine;

    public static final String CTX_EMAIL="email";
    public static final String CTX_ID="id";

    public void sendDownloadEmail(String email,String id, DownloadItem downloadItem){
        Template template = velocityEngine.getTemplate("/WEB-INF/velocity/template/download_email.vm");
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        String emailContent = writer.getBuffer().toString();
        mailMessage.setFrom("tanyajava <tanya.jv@gmail.com>");
        mailMessage.setText(emailContent);
        mailSender.send(mailMessage);
    }

}
