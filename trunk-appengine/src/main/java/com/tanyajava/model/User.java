/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long id;

    @Column(name="USER_NAME",length=100,unique=true)
    private String username;

    @Column(name="EMAIL",length=100,unique=true)
    private String email;

    @ManyToMany
    @JoinTable(joinColumns=@JoinColumn(name="USER_ID"),
        inverseJoinColumns=@JoinColumn(name="BADGE_ID"))
    private List<Badge> badges;

    @OneToMany(mappedBy="assignee",cascade=CascadeType.ALL)
    private List<Grp> assignedGrp;

    @OneToMany(mappedBy="assigner",cascade=CascadeType.ALL)
    private List<Grp> earnedGrp;

    @OneToMany(mappedBy="assignee",cascade=CascadeType.ALL)
    private List<Brp> assignedBrp;

    @OneToMany(mappedBy="assigner",cascade=CascadeType.ALL)
    private List<Brp> earnedBrp;

    public List<Brp> getAssignedBrp() {
        return assignedBrp;
    }

    public void setAssignedBrp(List<Brp> assignedBrp) {
        this.assignedBrp = assignedBrp;
    }

    public List<Brp> getEarnedBrp() {
        return earnedBrp;
    }

    public void setEarnedBrp(List<Brp> earnedBrp) {
        this.earnedBrp = earnedBrp;
    }

    public List<Grp> getAssignedGrp() {
        return assignedGrp;
    }

    public void setAssignedGrp(List<Grp> assignedGrp) {
        this.assignedGrp = assignedGrp;
    }

    public List<Grp> getEarnedGrp() {
        return earnedGrp;
    }

    public void setEarnedGrp(List<Grp> earnedGrp) {
        this.earnedGrp = earnedGrp;
    }


    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
