/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.dao.UserDao;
import com.tanyajava.model.Badge;
import com.tanyajava.model.User;
import com.tanyajava.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

    @Autowired private UserDao userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    public User getUser(Long id) {
        return userDao.findById(id);
    }

    public List<User> getUser(int start, int num) {
        return userDao.getUser(start,num);
    }

    public List<User> getUser(Badge badge, int start, int num) {
        return userDao.getUser(badge,start,num);
    }

}
