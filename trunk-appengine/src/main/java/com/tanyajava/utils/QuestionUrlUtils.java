/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.utils;

import com.tanyajava.model.Question;

/**
 *
 * @author ifnu
 */
public class QuestionUrlUtils {

    public static String getUrl(Question q){
        String url = q.getTitle().replace(" ","-");
        if(url.length()>20){
            return url.substring(0,20);
        } else {
            return url;
        }
    }

}
