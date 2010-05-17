/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.Tag;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface TagDao {

    public Tag findById(String id);

    public Tag save(Tag domain);

    public void delete(Tag domain);

    public List<Tag> findAll(Integer startIndex, Integer pageSize);

}
