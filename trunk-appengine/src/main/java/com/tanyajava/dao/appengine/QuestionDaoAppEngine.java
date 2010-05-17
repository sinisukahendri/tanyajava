/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao.appengine;

import com.tanyajava.dao.QuestionDao;
import com.tanyajava.model.Question;
import com.tanyajava.utils.QuestionUrlUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class QuestionDaoAppEngine implements QuestionDao{

    @PersistenceContext private EntityManager entityManager;

    public Question findById(String name) {
        return entityManager.find(Question.class, name);
    }

    public Question save(Question question) {

        if(question!=null){
            //set question url
            question.setUrl(QuestionUrlUtils.getUrl(question));
            int i = 1;
            while(entityManager.createQuery("select q from Question q where q.url=:url")
                    .setParameter("url", question.getUrl())
                    .getResultList().size()!=0
                    ){
                question.setUrl(question.getUrl() + i++);
            }
            entityManager.persist(question);
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

    public Question findByUrl(String url) {
        Question q = (Question) entityManager.createQuery("select q from Question q where q.url=:url")
                .setParameter("url", url)
                .getSingleResult();
        if(q!=null){
            if(q.getTags()!=null){
                q.getTags().size();
            }
            if(q.getAnswers()!=null){
                q.getAnswers().size();
            }
        }
        return q;
    }
}
