/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.dao.DownloadDao;
import com.tanyajava.dao.SequenceDao;
import com.tanyajava.model.Sequence;
import com.tanyajava.service.DownloadService;
import com.tanyajava.model.Download;
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

    public Download getDownload(String id) {
        return downloadDao.getById(id);
    }

    @Transactional(readOnly=false, isolation=Isolation.SERIALIZABLE)
    public void save(Download download) {
        String seq = sequenceDao.getNextDownloadSequence();
        if(download.getId() == null){
            download.setId(seq);
            downloadDao.save(download);
        } else {
            downloadDao.update(download);
        }
    }
}
