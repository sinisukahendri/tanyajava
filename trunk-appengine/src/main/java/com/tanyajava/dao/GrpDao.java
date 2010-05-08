/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.Grp;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface GrpDao {
    public Grp findById(Long id);

    public Grp save(Grp domain);

    public void delete(Grp domain);

    public List<Grp> findAll(Integer startIndex, Integer pageSize);

}
