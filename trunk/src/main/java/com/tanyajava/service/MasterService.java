/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service;

import com.tanyajava.model.Category;
import com.tanyajava.model.Question;
import com.tanyajava.model.Tag;
import com.tanyajava.model.CompanyRole;
import com.tanyajava.model.ProjectStage;
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

    List<CompanyRole> getCompanyRoles();
    List<ProjectStage> getProjectStages();


}
