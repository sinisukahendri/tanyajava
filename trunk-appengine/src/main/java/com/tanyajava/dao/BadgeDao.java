/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.Badge;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface BadgeDao {
    public Badge findById(Long id);

    public Badge save(Badge domain);

    public void delete(Badge domain);

    public List<Badge> findAll(Integer startIndex, Integer pageSize);

}
