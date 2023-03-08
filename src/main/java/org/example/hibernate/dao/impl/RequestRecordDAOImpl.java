package org.example.hibernate.dao.impl;

import org.example.hibernate.RequestRecord;
import org.example.hibernate.dao.RequestRecordDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by skeane on 3/2/2023.
 */
public class RequestRecordDAOImpl implements RequestRecordDAO {

    private static final Logger logger = LoggerFactory.getLogger(RequestRecordDAOImpl.class);

    public void removeUser(int usedId) {
        EntityManager manager = ;
        CriteriaBuilder builder = new CriteriaBuilder(maneger);
        CriteriaQuery query = builder.createQuery(RequestRecord.class);


    }
}
