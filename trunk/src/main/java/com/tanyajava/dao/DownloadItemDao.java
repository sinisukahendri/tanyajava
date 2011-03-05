/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.dao.base.BaseDaoHibernate;
import com.tanyajava.model.DownloadItem;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class DownloadItemDao extends BaseDaoHibernate<DownloadItem>{

    public DownloadItem findById(String downloadItemId) {
        return (DownloadItem) sessionFactory.getCurrentSession()
                .get(DownloadItem.class, downloadItemId);
    }

}
