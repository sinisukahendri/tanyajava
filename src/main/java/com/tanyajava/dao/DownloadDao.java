/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.dao.base.BaseDaoHibernate;
import com.tanyajava.model.Download;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class DownloadDao extends BaseDaoHibernate<Download>{

    public Download getById(String id){
        Download d = (Download) sessionFactory.getCurrentSession()
                .createQuery("from Download d where d.id=:id")
                .setString("id", id)
                .uniqueResult();
        return d;
    }

    @Override
    public Download save(Download domain) {
        sessionFactory.getCurrentSession()
                .save(domain);
        return domain;
    }

    public Download update(Download d){
        sessionFactory.getCurrentSession()
                .update(d);
        return d;
    }


}
