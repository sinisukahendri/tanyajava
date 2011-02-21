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
@Table(name="T_COMPANY_ROLE")
public class CompanyRole implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    
    @Column(name="COMPANY_ROLE",length=30)
    private String companyRole;

    public String getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
