/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.model;

import com.google.appengine.api.datastore.Key;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;

/**
 *
 * @author ifnu
 */
@Entity
public class Question implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key id;

    private String url;

    private String title;

    @Lob
    private String question;

//    @OneToMany
//    private List<Tag> tags;

//    @OneToMany(mappedBy = "question")
//    private List<Answer> answers;

//    @ManyToOne
//    private User user;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    private Boolean answered = Boolean.FALSE;

    private Long viewed;

    public Boolean isAnswered() {
        return answered;
    }

    public void setAnswered(Boolean answered) {
        this.answered = answered;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Tag> getTags() {
//        return tags;
        return null;
    }

    public void setTags(List<Tag> tags) {
//        this.tags = tags;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Long getViewed() {
        return viewed;
    }

    public void setViewed(Long viewed) {
        this.viewed = viewed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Answer> getAnswers() {
//        return answers;
        return null;
    }

    public void setAnswers(List<Answer> answers) {
//        this.answers = answers;
    }


}
