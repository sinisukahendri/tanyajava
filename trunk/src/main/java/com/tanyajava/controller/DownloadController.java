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
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
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
    
    @RequestMapping(value="/download/error", method=RequestMethod.GET)
    public String downloadError(Model model){
        return "/download/download_error";
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
        return "redirect:/download/done";
    }
    
    @RequestMapping(value="/download/{id}/{iddownload}", method=RequestMethod.GET)
    public String getDownload(@PathVariable String id,
            @PathVariable String iddownload,
            HttpServletResponse response){
        Download d = downloadService.getDownload(iddownload);
        DownloadItem item = d.getDownloadItem();
        if(d != null && d.getStatus().equals(Download.STATUS_CREATED)){
            BufferedInputStream inputStream = null;
            try {
                d.setDownloadedDate(new Date());
                d.setStatus(Download.STATUS_DOWNLOADED);
                downloadService.update(d);
                response.setContentType(item.getFileMimeType());
                response.setHeader("Content-Disposition", "attachment; filename=" + item.getFileName());
                inputStream = new BufferedInputStream(new FileInputStream(item.getFileAbsolutePath()));
                byte[] buffer = new byte[1024];
                int bytesRead;
                OutputStream outputStream = response.getOutputStream();
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DownloadController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DownloadController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(DownloadController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return null;
        } else {
            return "redirect:/download/error";
        }
    }

}
