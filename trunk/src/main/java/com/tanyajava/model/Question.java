/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="QUESTION")
public class Question implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="URL",length=255,unique=true)
    private String url;

    @Lob
    @Column(name="QUESTION")
    private String question;

    @ManyToMany
    @JoinTable(name="QUESTION_CATEGORY",
        joinColumns=@JoinColumn(name="ID_QUESTION"),
        inverseJoinColumns=@JoinColumn(name="ID_CATEGORY"))
    private List<Category> categories;

    private List<Tag> tags;

    @OneToMany
    @JoinColumn(name="ID_USER",referencedColumnName="ID")
    private User user;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name="ANSWERED")
    private Boolean answered = Boolean.FALSE;

    @Column(name="VIEWED")
    private Long viewed;

    public Boolean isAnswered() {
        return answered;
    }

    public void setAnswered(Boolean answered) {
        this.answered = answered;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getViewed() {
        return viewed;
    }

    public void setViewed(Long viewed) {
        this.viewed = viewed;
    }


}
