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
public interface BadgeService {
    void save(Badge badge);
    void delete(Badge badge);
    Badge getBadge(Long id);
    List<Badge> getBadge(User user, int start, int num);

}
