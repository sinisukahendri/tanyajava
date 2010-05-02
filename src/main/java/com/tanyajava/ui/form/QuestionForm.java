/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.ui.form;

/**
 *
 * @author ifnu
 */
public class QuestionForm {

    private String question;
    private String title;
    private String tags;
    private String categories;

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
