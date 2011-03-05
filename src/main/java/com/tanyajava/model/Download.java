/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_DOWNLOAD")
public class Download implements Serializable {

    public static final String STATUS_CREATED = "C";
    public static final String STATUS_DOWNLOADED = "D";

    @Id
    @Column(name="DOWNLOAD_ID",length=20)
    private String id;

    @NotEmpty
    @Size(min=1,max=100)
    @Email
    @Column(name="EMAIL",length=100,nullable=false)
    private String email;

    @NotEmpty
    @Size(min=1,max=100)
    @Email
    private transient String confirmEmail;

    @NotEmpty
    @Size(min=1,max=100)
    @Column(name="BLOG",length=100,nullable=false)
    private String blog;

    @NotEmpty
    @Size(min=1,max=100)
    @Column(name="USER_NAME",length=100,nullable=false)
    private String name;

    @NotEmpty
    @Size(min=1,max=100)
    @Column(name="COMPANY",length=100,nullable=false)
    private String company;

    @NotEmpty
    @Column(name="COMPANY_ROLE",length=30)
    private String companyRole;

    @Column(name="TEAM_SIZE")
    private Integer teamSize;

    @Column(name="PHONE")
    private String phone;

    @Column(name="PROJECT_STAGE",length=30)
    private String projectStage;

    @Column(name="NEWSLETTER")
    private Boolean newsLetter;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="DOWNLOAD_DATE")
    private Date downloadDate = new Date();

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="DOWNLOADED_DATE")
    private Date downloadedDate ;

    @Column(name="STATUS", length=1)
    private String status = STATUS_CREATED;

    @ManyToOne
    @Column(name="DOWNLOAD_ITEM_FK",nullable=false)
    private DownloadItem downloadItem;

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyRole() {
        return companyRole;
    }

    public void setCompanyRole(String companyRole) {
        this.companyRole = companyRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(Boolean newsLetter) {
        this.newsLetter = newsLetter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProjectStage() {
        return projectStage;
    }

    public void setProjectStage(String projectStage) {
        this.projectStage = projectStage;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public Date getDownloadedDate() {
        return downloadedDate;
    }

    public void setDownloadedDate(Date downloadedDate) {
        this.downloadedDate = downloadedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public DownloadItem getDownloadItem() {
        return downloadItem;
    }

    public void setDownloadItem(DownloadItem downloadItem) {
        this.downloadItem = downloadItem;
    }

}
