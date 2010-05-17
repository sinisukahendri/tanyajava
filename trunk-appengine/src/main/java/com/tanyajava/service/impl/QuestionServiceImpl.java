/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.dao.QuestionDao;
import com.tanyajava.model.Question;
import com.tanyajava.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service("questionService")
@Transactional(readOnly=true)
public class QuestionServiceImpl implements QuestionService{

    @Autowired private QuestionDao questionDao;

    @Transactional
    public void save(Question question) {
        questionDao.save(question);
    }

    @Transactional
    public void delete(Question question) {
        questionDao.delete(question);
    }

    public Question getQuestion(Long id) {
        return questionDao.findById(id);
    }

    public List<Question> getQuestion(int start, int num) {
        return questionDao.findAll(start,num);
    }

    public List<Question> getQuestion(String keyword, int start, int num) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Question getQuestionByUrl(String url) {
        return questionDao.findByUrl(url);
    }

}
