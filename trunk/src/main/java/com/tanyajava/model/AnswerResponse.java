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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ifnu
 */
@Entity
@Table(name="ANSWER_RESPONSE")
public class AnswerResponse implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @Column(name="RESPONSE")
    private String response;

    @ManyToOne(optional=false)
    private User user;


}
