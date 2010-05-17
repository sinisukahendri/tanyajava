/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao.appengine;

import com.tanyajava.dao.QuestionDao;
import com.tanyajava.model.Question;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class QuestionDaoAppEngine implements QuestionDao{
    @Autowired private EntityManager entityManager;

    public Question findById(String name) {
        return entityManager.find(Question.class, name);
    }

    public Question save(Question question) {
        if(question!=null){
            Question persistenceTag = entityManager.find(Question.class, question.getId());
            if(persistenceTag==null){
                entityManager.persist(question);
            } else {
                entityManager.merge(question);
            }
        }
        return question;
    }

    public void delete(Question question) {
        entityManager.remove(question);
    }

    public Question findById(Long id) {
        Question q = (Question) entityManager.createQuery("select q from Question q where q.id=:id")
                .setParameter("id", id)
                .getSingleResult();
        if(q!=null){
            q.getTags().size();
        }
        return q;
    }

    public List<Question> findAll(Integer startIndex, Integer pageSize) {
        return entityManager.createQuery("select q from Question q")
                .setFirstResult(startIndex)
                .setMaxResults(pageSize)
                .getResultList();
        
    }
}
