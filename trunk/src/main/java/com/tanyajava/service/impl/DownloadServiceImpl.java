/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.dao.DownloadDao;
import com.tanyajava.dao.DownloadItemDao;
import com.tanyajava.dao.SequenceDao;
import com.tanyajava.service.DownloadService;
import com.tanyajava.model.Download;
import com.tanyajava.model.DownloadItem;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service(value="downloadService")
@Transactional(readOnly=true)
public class DownloadServiceImpl implements DownloadService {

    @Autowired private DownloadDao downloadDao;
    @Autowired private SequenceDao sequenceDao;
    @Autowired private EmailSenderService emailSenderService;
    @Autowired private DownloadItemDao downloadItemDao;
    
    private static final Logger log = Logger.getLogger(DownloadServiceImpl.class);

    public Download getDownload(String id) {
        return downloadDao.getById(id);
    }

    @Transactional(readOnly=false, isolation=Isolation.SERIALIZABLE)
    public void save(Download download, String downloadItemId) {
        String seq = sequenceDao.getNextDownloadSequence();
        DownloadItem downloadItem = downloadItemDao.findById(downloadItemId);
        assert download != null;
        assert downloadItem != null;
        if(download.getId() == null){
            download.setId(seq);
            download.setDownloadItem(downloadItem);
            downloadDao.save(download);
            log.debug("successfuly insert download request");
        } else {
            downloadDao.update(download);
        }
        //sekalian send email
        emailSenderService.sendDownloadEmail(download, downloadItem);
        log.debug("successfuly send email");
    }

    public DownloadItem getDownloadItem(String id) {
        return downloadItemDao.findById(id);
    }

    @Transactional(readOnly=false,isolation=Isolation.SERIALIZABLE)
    public void update(Download download) {
        downloadDao.update(download);
    }

    public List<DownloadItem> getDownloadItems() {
        return downloadItemDao.findAll();
    }
}
