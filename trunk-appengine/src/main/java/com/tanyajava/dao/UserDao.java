/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.model.User;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface UserDao {
    public User findById(Long id);

    public User save(User domain);

    public void delete(User domain);

    public List<User> findAll(Integer startIndex, Integer pageSize);

}
