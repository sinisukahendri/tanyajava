/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.dao.base.BaseDaoHibernate;
import com.tanyajava.model.Badge;
import com.tanyajava.model.User;
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

    public User getUserByEmail(String email){
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User u where u.email=:email")
                .setParameter("email", email)
                .uniqueResult();
    }

}
