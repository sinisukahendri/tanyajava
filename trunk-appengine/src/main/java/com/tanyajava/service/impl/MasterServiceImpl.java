/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.service.impl;

import com.tanyajava.dao.TagDao;
import com.tanyajava.model.Tag;
import com.tanyajava.service.MasterService;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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

    @Transactional
    public void save(Tag tag) {
        tagDao.save(tag);
    }

    @Transactional
    public void delete(Tag tag) {
        tagDao.delete(tag);
    }

    public Tag getTag(String name) {
        return tagDao.findById(name);
    }

    public List<Tag> getTag(int start, int num) {
//        return tagDao.getTag(start,num);
        return null;
    }

    public List<Tag> save(String tags) {
        String token = null;
        StringTokenizer tokenizer = new StringTokenizer(tags);
        List<Tag> tagList = new ArrayList<Tag>();
        while(tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();
            Tag t =tagDao.findById(token);
            if(t==null){
                t = new Tag();
                t.setAssigned(0l);
                t.setName(token);
                tagDao.save(t);
            }
            tagList.add(t);
        }
        return tagList;
    }


}
