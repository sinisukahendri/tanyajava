/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.AnswerResponse;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface AnswerResponseDao {
    public AnswerResponse findById(Long id);

    public AnswerResponse save(AnswerResponse domain);

    public void delete(AnswerResponse domain);

    public List<AnswerResponse> findAll(Integer startIndex, Integer pageSize);

}
