/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.connect;

import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.support.Connection;
import org.springframework.social.connect.support.ConnectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service("connectionRepository")
@Transactional(readOnly=true)
public class HibernateConnectionRepository implements ConnectionRepository{

    @Autowired private SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(HibernateConnectionRepository.class);

    public boolean isConnected(Serializable accountId, String providerId) {
        Long count = (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(*) from Connection c where c.accountId=:accountId and c.providerId=:providerId")
                .setParameter("accountId", accountId)
                .setParameter("providerId", providerId)
                .uniqueResult();
        return count !=null && count > 0;
    }

    public List<Connection> findConnections(Serializable accountId, String providerId) {
        return sessionFactory.getCurrentSession()
                .createQuery("select c.id as id, "
                    + "c.accessToken as accessToken, "
                    + "c.secret as secret, "
                    + "c.refreshToken as refreshToken, "
                    + "c.providerAccountId as providerAccountId, "
                    + "from Connection c where c.accountId=:accountId and c.providerId=:providerId")
                .setParameter("accountId", accountId)
                .setParameter("providerId", providerId)
                .setResultTransformer(Transformers.aliasToBean(Connection.class))
                .list();
    }

    public Serializable findAccountIdByConnectionAccessToken(String providerId, String accessToken) {
        List<String> accountIds =  sessionFactory.getCurrentSession()
                .createQuery("select distinct c.accountId from Connection c where c.providerId=:providerId and c.accessToken=:accessToken")
                .setParameter("providerId", providerId)
                .setParameter("accessToken", accessToken)
                .list();
        if(accountIds.size()> 1){
            logger.error("accountId for providerId " + providerId + " and accessToken " + accessToken + " is more than 1!");
        }
        if(!accessToken.isEmpty()){
            return accountIds.get(0);
        }
        return 0;
    }

    public List<Serializable> findAccountIdsForProviderAccountIds(String providerId, List<String> providerAccountIds) {
        return sessionFactory.getCurrentSession()
                .createQuery("select c.accountId from Connection c "
                    + "where c.providerId=:providerId and c.providerAccountId in (:providerAccountIds)")
                .setParameter("providerId", providerId)
                .setParameter("providerAccountIds", providerAccountIds)
                .list();
    }

    @Transactional(readOnly=false)
    public Connection saveConnection(Serializable accountId, String providerId, Connection connection) {
        com.tanyajava.model.Connection c = new com.tanyajava.model.Connection();
        BeanUtils.copyProperties(connection, c);
        c.setAccountId(accountId.toString());
        c.setProviderId(providerId);
        sessionFactory.getCurrentSession().save(c);
        BeanUtils.copyProperties(c, connection);
        return connection;
    }

    @Transactional(readOnly=false)
    public void removeConnection(Serializable accountId, String providerId, Long connectionId) {
        com.tanyajava.model.Connection c = (com.tanyajava.model.Connection) sessionFactory.getCurrentSession()
                .get(com.tanyajava.model.Connection.class, connectionId);
        sessionFactory.getCurrentSession().delete(c);
    }


}
