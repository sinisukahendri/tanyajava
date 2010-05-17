/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service;

import com.tanyajava.model.Tag;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface MasterService {

    void save(Tag tag);
    List<Tag> save(String tags);
    void delete(Tag tag);
    Tag getTag(String id);
    List<Tag> getTag(int start, int num);


}
