/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao.appengine;

import com.tanyajava.dao.TagDao;
import com.tanyajava.model.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class TagDaoAppEngine implements TagDao{

    @Autowired private EntityManager entityManager;

    public Tag findById(String name) {
        return entityManager.find(Tag.class, name);
    }

    public Tag save(Tag tag) {
        if(tag!=null){
            Tag persistenceTag = entityManager.find(Tag.class, tag.getName());
            if(persistenceTag==null){
                entityManager.persist(tag);
            } else {
                entityManager.merge(tag);
            }
        }
        return tag;
    }

    public void delete(Tag tag) {
        entityManager.remove(tag);
    }

    public List<Tag> findAll(Integer startIndex, Integer pageSize) {
        return entityManager.createQuery("select t from Tag t")
                .setFirstResult(startIndex)
                .setMaxResults(pageSize)
                .getResultList();
    }

}
