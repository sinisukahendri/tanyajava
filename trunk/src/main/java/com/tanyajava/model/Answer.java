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
@Table(name="T_ANSWER")
public class Answer implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="ANSWER_ID")
    private Long id;

    @Lob
    @Column(name="ANSWER")
    private String answer;

    @ManyToOne(optional=false)
    @JoinColumn(name="QUESTION_ID",referencedColumnName="QUESTION_ID")
    private Question question;

    @Column(name="VOTED_UP")
    private Long votedUp=0l;

    @Column(name="VOTED_DOWN")
    private Long votedDown=0l;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID",referencedColumnName="USER_ID")
    private User user;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="DATE_CREATED",updatable=false)
    private Date dateCreated = new Date();

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getVotedDown() {
        return votedDown;
    }

    public void setVotedDown(Long votedDown) {
        this.votedDown = votedDown;
    }

    public Long getVotedUp() {
        return votedUp;
    }

    public void setVotedUp(Long votedUp) {
        this.votedUp = votedUp;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public Long getTotalVote(){
        Long total = votedUp - votedDown;
        if(total < 0) return 0l;
        return total;
    }
    
    public String getDuration(){
        return "1 menit";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Answer other = (Answer) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    
}
