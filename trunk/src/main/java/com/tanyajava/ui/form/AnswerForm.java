/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanyajava.ui.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ifnu
 */
public class AnswerForm {
    @NotEmpty
    private String answer;

    private String userName;
    private String email;
    private String homePage;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
