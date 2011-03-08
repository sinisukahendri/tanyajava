/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service;

import com.tanyajava.model.Tag;
import com.tanyajava.model.CompanyRole;
import com.tanyajava.model.ProjectStage;
import java.util.List;

/**
 *
 * @author ifnu
 */
public interface MasterService {

    void save(Tag tag);
    void delete(Tag tag);
    Tag getTag(String tag);
    Tag getTag(Long id);
    List<Tag> getTag(int start, int num);

    List<CompanyRole> getCompanyRoles();
    List<ProjectStage> getProjectStages();



}
