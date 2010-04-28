/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.tanyajava.service;

import com.artivisi.tanyajava.model.Answer;
import com.artivisi.tanyajava.model.Question;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface AnswerService {

    void save(Answer answer);
    void delete(Answer answer);
    Answer getAnswer(Long id);
    List<Answer> getAnswer(Question question, int start, int num);

}
