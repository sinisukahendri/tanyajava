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
        
        String lastSequence = sequence.getSequance();
        char c = sequence.getSequance().charAt(sequence.getSequance().length()-1);
        if((c >= '0' && c < '9')
                || (c>='a' && c < 'z')) {
            c++;
            lastSequence = replaceLastChar(lastSequence, c);
        } else if (c == '9') {
            c = 'a';
            lastSequence = replaceLastChar(lastSequence, c);
        } else if (c == 'z'){
            lastSequence += '0';
        }
        sequence.setSequance(lastSequence);
        save(sequence);
        return lastSequence;
    }
    public String replaceLastChar(String str, char c){
        String replaced = str.substring(0,str.length()-2);
        return replaced + c;
    }

}
