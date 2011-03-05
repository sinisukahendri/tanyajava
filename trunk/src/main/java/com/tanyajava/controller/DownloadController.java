/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.controller;

import com.tanyajava.service.DownloadService;
import com.tanyajava.service.MasterService;
import com.tanyajava.model.Download;
import com.tanyajava.model.DownloadItem;
import com.tanyajava.service.impl.EmailSenderService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu
 */
@Controller
public class DownloadController {

    @Autowired private MasterService masterService;
    @Autowired private DownloadService downloadService;
    @Autowired private EmailSenderService emailSenderService;

    @RequestMapping(value="/download/{id}", method=RequestMethod.GET)
    public String viewDownload(@PathVariable String id, Model model){
        model.addAttribute("companyRoles",masterService.getCompanyRoles());
        model.addAttribute("projectStages",masterService.getProjectStages());
        DownloadItem downloadItem = downloadService.getDownloadItem(id);
        if(downloadItem == null){
            //exception
        }
        model.addAttribute("content",downloadItem.getContent());
        model.addAttribute("title",downloadItem.getTitle());
        model.addAttribute(new Download());
        return "/download/" + id;
    }
    @RequestMapping(value="/download/done", method=RequestMethod.GET)
    public String downloadDone(Model model){
        return "/download/download_done";
    }
    
    @RequestMapping(value="/download/{id}",method=RequestMethod.POST)
    public String getDownload(@PathVariable String id,
            @Valid Download download,
            BindingResult result,
            Model model){
        if(!result.hasErrors()){
            if(download.getNewsLetter() == null){
                download.setNewsLetter(Boolean.FALSE);
            }
            //save download data and send email
            downloadService.save(download, id);
            
        } else if(result.hasErrors()){
            return "/download/" + id;
        }
        return "redirect:/j/download/done";
    }
    
    @RequestMapping(value="/download/{id}/{iddownload}", method=RequestMethod.GET)
    public void getDownload(@PathVariable String id,
            @PathVariable String iddownload){
        Download d = downloadService.getDownload(iddownload);
        if(d != null && d.getStatus().equals(Download.STATUS_CREATED)){
            d.setDownloadedDate(new Date());
            d.setStatus(Download.STATUS_DOWNLOADED);
            downloadService.update(d);

            //

        } else {

        }
    }

}
