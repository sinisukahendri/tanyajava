/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.tanyajava.dao;

import com.artivisi.tanyajava.dao.base.BaseDaoHibernate;
import com.artivisi.tanyajava.model.Badge;
import com.artivisi.tanyajava.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class UserDao extends BaseDaoHibernate<User>{

    public List<User> getUser(int start, int num) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User u")
                .setFirstResult(start)
                .setMaxResults(num)
                .list();
    }

    public List<User> getUser(Badge badge, int start, int num) {
        return sessionFactory.getCurrentSession()
                .createQuery("from User u left join fetch u.badges b where b=:badge")
                .setEntity("badge", badge)
                .setFirstResult(start)
                .setMaxResults(num)
                .list();
    }

}
