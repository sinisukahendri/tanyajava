/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_DOWNLOAD_ITEM")
public class DownloadItem implements Serializable {

    @Id
    @Column(name="DOWNLOAD_ITEM_ID",length=15)
    private String id;

    @Column(name="TITLE",length=100)
    private String title;
    
    @Lob
    @Column(name="CONTENT")
    private String content;

    @Column(name="FILE_ABSOLUTE_PATH",length=150)
    private String fileAbsolutePath;

    @Column(name="FILE_MIME_TYPE",length=150)
    private String fileMimeType;

    @Column(name="FILE_NAME",length=150)
    private String fileName;

    @Lob
    @Column(name="EMAIL_TEMPLATE")
    private String emailTemplate;

    @Column(name="EMAIL_SUBJECT",length=100)
    private String emailSubject;

    @Column(name="EMAIL_FROM",length=100)
    private String emailFrom;

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailTemplate() {
        return emailTemplate;
    }

    public void setEmailTemplate(String emailTemplate) {
        this.emailTemplate = emailTemplate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileAbsolutePath() {
        return fileAbsolutePath;
    }

    public void setFileAbsolutePath(String fileAbsolutePath) {
        this.fileAbsolutePath = fileAbsolutePath;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
