/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_ANSWER_RESPONSE")
public class AnswerResponse implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ANSWER_RESPONSE_ID")
    private Long id;

    @Lob
    @Column(name="RESPONSE")
    private String response;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID")
    private User user;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="DATE_CREATED",updatable=false)
    private Date dateCreated = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
