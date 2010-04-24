/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.tanyajava.model;

import java.util.List;

/**
 *
 * @author ifnu
 */
public class User {

    private Long id;

    private String username;

    private String email;

    private List<Badge> badges;

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
