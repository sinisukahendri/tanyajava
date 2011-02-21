/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.dao.CategoryDao;
import com.tanyajava.dao.CompanyRoleDao;
import com.tanyajava.dao.ProjectStageDao;
import com.tanyajava.dao.TagDao;
import com.tanyajava.model.Category;
import com.tanyajava.model.Tag;
import com.tanyajava.service.MasterService;
import com.tanyajava.model.CompanyRole;
import com.tanyajava.model.ProjectStage;
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
public class MasterServiceImpl implements MasterService{

    @Autowired private TagDao tagDao;
    @Autowired private CategoryDao categoryDao;
    @Autowired private ProjectStageDao projectStageDao;
    @Autowired private CompanyRoleDao companyRoleDao;

    @Transactional
    public void save(Category category) {
        categoryDao.save(category);
    }

    public void delete(Category category) {
        categoryDao.delete(category);
    }

    public Category getCategory(Long id) {
        return categoryDao.findById(id);
    }

    public List<Category> getCategory(int start, int num) {
        return categoryDao.getCategory(start, num);
    }

    @Transactional
    public void save(Tag tag) {
        tagDao.save(tag);
    }

    @Transactional
    public void delete(Tag tag) {
        tagDao.delete(tag);
    }

    public Tag getTag(Long id) {
        return tagDao.findById(id);
    }

    public List<Tag> getTag(int start, int num) {
        return tagDao.getTag(start,num);
    }

    public List<CompanyRole> getCompanyRoles() {
        return companyRoleDao.findAll();
    }

    public List<ProjectStage> getProjectStages() {
        return projectStageDao.findAll();
    }

}
