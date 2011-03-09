/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service;

import com.tanyajava.model.Badge;
import com.tanyajava.model.User;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface UserService {
    void save(User user);
    void delete(User user);
    User getUser(Long id);
    User getUserByEmail(String email);
    List<User> getUser(int start, int num);
    List<User> getUser(Badge badge,int start, int num);

}
