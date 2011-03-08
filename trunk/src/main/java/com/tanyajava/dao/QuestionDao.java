/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.dao.base.BaseDaoHibernate;
import com.tanyajava.model.Question;
import com.tanyajava.model.Tag;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class QuestionDao extends BaseDaoHibernate<Question>{

    public List<Question> getQuestion(int start, int num) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Question q")
                .setFirstResult(start)
                .setMaxResults(num)
                .list();
    }

    public List<Question> getQuestion(String keyword, int start, int num) {
        //TODO implementasi fulltext search
        return sessionFactory.getCurrentSession()
                .createQuery("from Question q")
                .setFirstResult(start)
                .setMaxResults(num)
                .list();
    }

    public List<Question> getQuestion(Tag tag, int start, int num) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Question q left join fetch q.tags t where t=:tag")
                .setEntity("tag", tag)
                .setFirstResult(start)
                .setMaxResults(num)
                .list();
    }

}
