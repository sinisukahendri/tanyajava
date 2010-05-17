/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao.appengine;

import com.tanyajava.dao.AnswerDao;
import com.tanyajava.model.Answer;
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
public class AnswerDaoAppEngine implements AnswerDao {

    @Autowired private EntityManager entityManager;

    public Answer findById(Long id) {
        return entityManager.find(Answer.class, id);
    }

    public Answer save(Answer domain) {
        if(domain.getId() == null){
            entityManager.persist(domain);
        } else {
            entityManager.merge(domain);
        }
        return domain;
    }

    public void delete(Answer domain) {
        entityManager.remove(domain);
    }

    public List<Answer> findAll(Question question, Integer startIndex, Integer pageSize) {
        return entityManager.createQuery("from Answer a where a.question=:question")
                .setParameter("question", question)
                .setFirstResult(startIndex)
                .setMaxResults(pageSize)
                .getResultList();
    }

}
