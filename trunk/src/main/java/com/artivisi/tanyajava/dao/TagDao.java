/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.tanyajava.dao;

import com.artivisi.tanyajava.dao.base.BaseDaoHibernate;
import com.artivisi.tanyajava.model.Tag;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class TagDao extends BaseDaoHibernate<Tag>{

    public List<Tag> getTag(int start, int num) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Tag t")
                .setFirstResult(start)
                .setMaxResults(num)
                .list();
    }

}
