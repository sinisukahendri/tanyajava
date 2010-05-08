/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao.base;

import java.util.List;

/**
 *
 * @author ifnu
 */
public interface BaseDaoInterface<T> {

    public T findById(Long id);

    public T save(T domain);

    public void delete(T domain);

    public List<T> findAll(Integer startIndex, Integer pageSize);
    

}
