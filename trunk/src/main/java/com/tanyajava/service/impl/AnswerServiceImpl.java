/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.dao.AnswerDao;
import com.tanyajava.model.Answer;
import com.tanyajava.model.Question;
import com.tanyajava.service.AnswerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service
@Transactional(readOnly=true)
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Transactional(readOnly=false)
    public void save(Answer answer) {
        answerDao.save(answer);
    }

    @Transactional(readOnly=false)
    public void delete(Answer answer) {
        answerDao.delete(answer);
    }

    public Answer getAnswer(Long id) {
        return answerDao.findById(id);
    }

    public List<Answer> getAnswer(Question question, int start, int num) {
        return answerDao.getAnswer(question, start, num);
    }

}
