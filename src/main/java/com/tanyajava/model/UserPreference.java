/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanyajava.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author ifnu
 */
@Entity
public class UserPreference implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="USER_PREFERENCE_ID")
    private Long id;
    
    @OneToOne(mappedBy="userPreference")
    private User user;
    
    @Column(name="TIME_ZONE",nullable=false)
    private String timeZone;

    @Column(name="DATE_FORMAT",nullable=false)
    private String dateFormat;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    
}
