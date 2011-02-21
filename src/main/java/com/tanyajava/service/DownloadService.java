/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service;

import com.tanyajava.model.Download;

/**
 *
 * @author ifnu
 */

public interface DownloadService {

    Download getDownload(String id);

    void save(Download download);

}
