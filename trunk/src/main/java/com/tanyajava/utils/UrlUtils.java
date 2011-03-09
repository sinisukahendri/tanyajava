/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ifnu
 */
public class UrlUtils {
    public static final Set<Character> BAD_CHAR = new HashSet<Character>(Arrays.asList(new Character[]{'#'}));

    public static String createFriendlyUrl(String title){
        char[] chars = title.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if(c == ' '){
                builder.append('-');
            } else if(!BAD_CHAR.contains(c)){
                builder.append(c);
            }
        }
        return builder.toString();
    }

}
