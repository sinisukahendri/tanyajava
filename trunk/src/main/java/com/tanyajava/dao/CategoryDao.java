/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.dao.base.BaseDaoHibernate;
import com.tanyajava.model.Category;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class CategoryDao extends BaseDaoHibernate<Category>{

    public List<Category> getCategory(int start, int num) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Category c ")
                .setFirstResult(start)
                .setMaxResults(num)
                .list();
    }

}
