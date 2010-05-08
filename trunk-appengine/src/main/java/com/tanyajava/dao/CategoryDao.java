/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.Category;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface CategoryDao {
    public Category findById(Long id);

    public Category save(Category domain);

    public void delete(Category domain);

    public List<Category> findAll(Integer startIndex, Integer pageSize);

}
