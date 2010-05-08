/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.Answer;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface AnswerDao extends ActionListener {

    public Answer findById(Long id);

    public Answer save(Answer domain);

    public void delete(Answer domain);

    public List<Answer> findAll(Integer startIndex, Integer pageSize);

}
