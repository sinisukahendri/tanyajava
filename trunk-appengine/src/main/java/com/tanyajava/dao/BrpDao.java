/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.Brp;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface BrpDao {
    public Brp findById(Long id);

    public Brp save(Brp domain);

    public void delete(Brp domain);

    public List<Brp> findAll(Integer startIndex, Integer pageSize);

}
