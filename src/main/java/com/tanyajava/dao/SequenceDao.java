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
        String nextSequence = null;
        if((c >= '0' && c < '9')
                || (c>='a' && c < 'z')) {
            c++;
            nextSequence = replaceLastChar(lastSequence, c);
        } else if (c == '9') {
            c = 'a';
            nextSequence = replaceLastChar(lastSequence, c);
        } else if (c == 'z'){
            nextSequence += '0';
        }
        return nextSequence;
    }
    
    public String replaceLastChar(String str, char c){
        if(str.length() == 1){
            return String.valueOf(c);
        }
        String replaced = str.substring(0,str.length()-1);
        return replaced + c;
    }

}
