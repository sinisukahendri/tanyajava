/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao.appengine;

import com.tanyajava.dao.UserDao;
import com.tanyajava.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class UserDaoAppEngine implements UserDao{

    @PersistenceContext private EntityManager entityManager;

    public User findById(String name) {
        return entityManager.find(User.class, name);
    }

    public User save(User user) {
        if(user!=null){
            User persistenceTag = entityManager.find(User.class, user.getId());
            if(persistenceTag==null){
                entityManager.persist(user);
            } else {
                entityManager.merge(user);
            }
        }
        return user;
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

    public User findById(Long id) {
        User q = (User) entityManager.createQuery("select q from User q where q.id=:id")
                .setParameter("id", id)
                .getSingleResult();
        if(q!=null){
//            q.getAssignedBrp().size();
        }
        return q;
    }

    public List<User> findAll(Integer startIndex, Integer pageSize) {
        return entityManager.createQuery("select q from User q")
                .setFirstResult(startIndex)
                .setMaxResults(pageSize)
                .getResultList();

    }

}
