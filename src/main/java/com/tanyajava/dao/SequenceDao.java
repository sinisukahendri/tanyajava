/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.dao;

import com.tanyajava.dao.base.BaseDaoHibernate;
import com.tanyajava.model.Sequence;
import com.tanyajava.model.SequenceEnum;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class SequenceDao extends BaseDaoHibernate<Sequence>{

    public String getNextDownloadSequence(){
        Sequence sequence = (Sequence) sessionFactory.getCurrentSession()
                .createQuery("from Sequence s where s.id=:id")
                .setString("id", SequenceEnum.DOWNLOAD.toString())
                .uniqueResult();
        if(sequence == null){
            sequence = new Sequence();
            sequence.setId(SequenceEnum.DOWNLOAD.toString());
            sequence.setSequance("0");
            save(sequence);
            return sequence.getSequance();
        }
        String nextSequence = getNextSequence(sequence);
        sequence.setSequance(nextSequence);
        this.save(sequence);
        return nextSequence;
    }
    
    public String getNextSequence(Sequence sequence){
        String lastSequence = sequence.getSequance();
        char c = lastSequence.charAt(lastSequence.length()-1);
        if(lastSequence.length()==1){
            c = lastSequence.charAt(0);
        }
        String nextSequence = lastSequence;
        if (c == 'z'){
            char[] sequenceChar =  lastSequence.toCharArray();
            boolean allZ = true;
            for(int i = lastSequence.length()-1; i >=0; i--){
                if(sequenceChar[i]!='z'){
                    allZ = false;
                    c = getNextChar(sequenceChar[i]);
                    if(i > 0){
                        nextSequence = lastSequence.substring(0, i-1) + c 
                            + lastSequence.substring(i+1, lastSequence.length())
                            + '0';
                    } else {
                        nextSequence =  c + lastSequence.substring(i+2, lastSequence.length())
                            + '0';
                    }
                    return nextSequence;
                } else {
                    sequenceChar[i] = '0';
                }
            }
            if(allZ){
                nextSequence = "1" + new String(sequenceChar);
            }
        } else {
            c = getNextChar(c);
            nextSequence = replaceLastChar(lastSequence, c);
        }
        return nextSequence;
    }
    
    public char getNextChar(char c){
        if((c >= '0' && c < '9')
                || (c>='a' && c < 'z')) {
            c++;
        } else if (c == '9') {
            c = 'a';
        }
        return c;
    }
    
    public String replaceLastChar(String str, char c){
        if(str.length() == 1){
            return String.valueOf(c);
        }
        String replaced = str.substring(0,str.length()-1);
        return replaced + c;
    }

}
