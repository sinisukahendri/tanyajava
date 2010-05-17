/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service;

import com.tanyajava.model.Question;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface QuestionService {

    void save(Question question);
    void delete(Question question);
    Question getQuestion(Long id);
    Question getQuestionByUrl(String url);
    List<Question> getQuestion(int start, int num);
    List<Question> getQuestion(String keyword, int start, int num);

}
