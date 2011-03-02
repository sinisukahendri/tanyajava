/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.controller;

import com.tanyajava.service.DownloadService;
import com.tanyajava.service.MasterService;
import com.tanyajava.model.Download;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ifnu
 */
@Controller
public class DownloadController {

    public static final String BUKU_JAVA_DESKTOP="bkjd";
    @Autowired private MasterService masterService;
    @Autowired private DownloadService downloadService;

    @RequestMapping(value="/download/{id}", method=RequestMethod.GET)
    public String viewDownload(@PathVariable String id, Model model){
        if(BUKU_JAVA_DESKTOP.equals(id)){
            model.addAttribute("companyRoles",masterService.getCompanyRoles());
            model.addAttribute("projectStages",masterService.getProjectStages());
            model.addAttribute(new Download());
        } 
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
        if(!result.hasErrors()
                && BUKU_JAVA_DESKTOP.equals(id)){
            if(download.getNewsLetter() == null){
                download.setNewsLetter(Boolean.FALSE);
            }
            downloadService.save(download);
            //TODO send email to user
            
        } else if(result.hasErrors()){
            return "/download/" + id;
        }
        return "redirect:/j/download/done";
    }
    
    @RequestMapping(value="/download/{id}/{iddownload}", method=RequestMethod.GET)
    public String getDownload(@PathVariable String id,
            @PathVariable String iddownload){
        if(BUKU_JAVA_DESKTOP.equals(id)){
            Download d = downloadService.getDownload(iddownload);
            if(d != null && d.getStatus().equals(Download.STATUS_CREATED)){
                d.setDownloadedDate(new Date());
                d.setStatus(Download.STATUS_DOWNLOADED);
                downloadService.save(d);
                return "redirect:/j/download/success";
            } else {
                
            }
        }
        return "redirect:/j/download/success";
    }

}
