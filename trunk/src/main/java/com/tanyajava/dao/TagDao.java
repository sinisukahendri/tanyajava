/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.dao.base.BaseDaoHibernate;
import com.tanyajava.model.Tag;
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

    public Tag findByName(String name) {
        return (Tag) sessionFactory.getCurrentSession()
                .createQuery("from Tag t where t.name=:name")
                .setParameter("name", name)
                .uniqueResult();
    }

}
