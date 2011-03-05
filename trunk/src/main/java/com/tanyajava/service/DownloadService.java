/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service;

import com.tanyajava.model.Download;
import com.tanyajava.model.DownloadItem;
import java.util.List;

/**
 *
 * @author ifnu
 */

public interface DownloadService {

    Download getDownload(String id);

    void save(Download download, String downloadItemId);

    void update(Download download);

    DownloadItem getDownloadItem(String id);
    List<DownloadItem> getDownloadItems();
}
