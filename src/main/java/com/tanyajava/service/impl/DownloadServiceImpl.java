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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service
@Transactional(readOnly=true)
public class DownloadServiceImpl implements DownloadService {

    @Autowired private DownloadDao downloadDao;
    @Autowired private SequenceDao sequenceDao;
    @Autowired private EmailSenderService emailSenderService;
    @Autowired private DownloadItemDao downloadItemDao;

    public Download getDownload(String id) {
        return downloadDao.getById(id);
    }

    @Transactional(readOnly=false, isolation=Isolation.SERIALIZABLE)
    public void save(Download download, String downloadItemId) {
        String seq = sequenceDao.getNextDownloadSequence();
        DownloadItem downloadItem = downloadItemDao.findById(downloadItemId);
        if(download.getId() == null){
            download.setId(seq);
            download.setDownloadItem(downloadItem);
            downloadDao.save(download);
        } else {
            downloadDao.update(download);
        }
        //sekalian send email
        emailSenderService.sendDownloadEmail(download.getEmail(), seq, downloadItem);
        
    }

    public DownloadItem getDownloadItem(String id) {
        return downloadItemDao.findById(id);
    }

    public void update(Download download) {
        downloadDao.update(download);
    }
}
