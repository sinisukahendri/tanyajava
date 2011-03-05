/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.model.Download;
import com.tanyajava.model.DownloadItem;
import com.tanyajava.template.VelocityEngineString;
import java.io.StringWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.node.SimpleNode;
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
    @Autowired private VelocityEngineString velocityEngine;

    public static final String CTX_NAME="name";
    public static final String CTX_ID="id";

    public void sendDownloadEmail(Download download, DownloadItem downloadItem){
        SimpleNode simpleNode = velocityEngine.getSimpleNode(downloadItem);
        assert simpleNode != null;
        Template template = new Template();
        template.setRuntimeServices(RuntimeSingleton.getRuntimeServices());
        template.setData(simpleNode);
        template.initDocument();
        VelocityContext context = new VelocityContext();
        context.put(CTX_NAME, download.getName());
        context.put(CTX_ID, download.getId());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        String emailContent = writer.getBuffer().toString();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(downloadItem.getEmailFrom());
        mailMessage.setSubject(downloadItem.getEmailSubject());
        mailMessage.setTo(download.getEmail());
        mailMessage.setText(emailContent);
        mailSender.send(mailMessage);
    }

}
