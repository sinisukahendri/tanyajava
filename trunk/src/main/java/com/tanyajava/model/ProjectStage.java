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
import javax.persistence.Table;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_PROJECT_STAGE")
public class ProjectStage implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="PS_ID")
    private Long id;

    @Column(name="PROJECT_STAGE",length=30)
    private String projectStage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectStage() {
        return projectStage;
    }

    public void setProjectStage(String projectStage) {
        this.projectStage = projectStage;
    }

    
}
