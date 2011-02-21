/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="T_SEQUENCE")
public class Sequence implements Serializable {

    @Id
    @Column(name="SEQ_ID")
    private String id;

    @Column(name="TYPE")
    private String type;
    @Column(name="LAST_SEQUENCE")
    private String sequance;
    @Column(name="SEQ_DATE")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSequance() {
        return sequance;
    }

    public void setSequance(String sequance) {
        this.sequance = sequance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
