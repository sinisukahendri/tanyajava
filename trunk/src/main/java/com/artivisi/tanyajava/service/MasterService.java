/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.tanyajava.service;

import com.artivisi.tanyajava.model.Category;
import com.artivisi.tanyajava.model.Question;
import com.artivisi.tanyajava.model.Tag;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface MasterService {

    void save(Category category);
    void delete(Category category);
    Category getCategory(Long id);
    List<Category> getCategory(int start, int num);

    void save(Tag tag);
    void delete(Tag tag);
    Tag getTag(Long id);
    List<Tag> getTag(int start, int num);


}
