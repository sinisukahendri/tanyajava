/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.Answer;
import com.tanyajava.model.Question;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface AnswerDao {

    public Answer findById(Long id);

    public Answer save(Answer domain);

    public void delete(Answer domain);

    public List<Answer> findAll(Question question, Integer startIndex, Integer pageSize);

}
