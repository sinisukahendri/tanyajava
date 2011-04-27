/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.controller;

import com.tanyajava.service.DownloadService;
import com.tanyajava.service.MasterService;
import com.tanyajava.model.Download;
import com.tanyajava.model.DownloadItem;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.log4j.Logger;
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
    
    private static final Logger logger = Logger.getLogger(DownloadController.class);

    @RequestMapping(value="/download", method=RequestMethod.GET)
    public String viewDownloadList(Model model){
        model.addAttribute("downloadItems",downloadService.getDownloadItems());
        return "/download/download_list";
    }
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
        return "/download/download";
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
            model.addAttribute("download", download);
            return "/download/download";
        }
        return "redirect:/download/done";
    }
    
    @RequestMapping(value="/download/{id}/{iddownload}", method=RequestMethod.HEAD)
    public String getDownloadHead(@PathVariable String id,
            @PathVariable String iddownload,
            HttpServletResponse response){
        logger.debug("HEAD called");
        Download d = downloadService.getDownload(iddownload);
        if(d!=null && d.getDownloadItem()!=null){
            DownloadItem item = d.getDownloadItem();
            response.setContentType(item.getFileMimeType());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + item.getFileName() + "\"");
            File f = new File(item.getFileAbsolutePath());
            response.setContentLength((int)f.length());
            logger.debug("size : " + f.length());
        }
        return null;
    }
    
    @RequestMapping(value="/download/{id}/{iddownload}", method=RequestMethod.GET)
    public String getDownload(@PathVariable String id,
            @PathVariable String iddownload,
            HttpServletResponse response){
        Download d = downloadService.getDownload(iddownload);
        if(d != null && d.getCount() < 10){
            DownloadItem item = d.getDownloadItem();
            BufferedInputStream inputStream = null;
            try {
                d.setDownloadedDate(new Date());
                d.setStatus(Download.STATUS_DOWNLOADED);
                d.setCount(d.getCount() + 1);
                downloadService.update(d);
                response.setContentType(item.getFileMimeType());
                response.setHeader("Content-Disposition", "attachment; filename=\"" + item.getFileName() + "\"");
                File f = new File(item.getFileAbsolutePath());
                response.setContentLength((int)f.length());
                inputStream = new BufferedInputStream(new FileInputStream(f));
                logger.debug("content length : " + f.length());
                byte[] buffer = new byte[1024];
                int bytesRead;
                OutputStream outputStream = response.getOutputStream();
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (FileNotFoundException ex) {
                logger.error(ex);
            } catch (IOException ex) {
                logger.error(ex);
            } finally {
                try {
                    if(inputStream!=null){
                        inputStream.close();
                    }
                } catch (IOException ex) {
                    logger.error(ex);
                }
            }
            return null;
        } else {
            return "redirect:/download/error";
        }
    }

}
