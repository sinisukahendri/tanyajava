/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.Question;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface QuestionDao {
    public Question findById(Long id);

    public Question save(Question domain);

    public void delete(Question domain);

    public List<Question> findAll(Integer startIndex, Integer pageSize);

    public Question findByUrl(String url);

}
