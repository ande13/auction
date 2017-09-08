package com.auction.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.Map;

public class BaseDAO {

    <T> Query<T> createQuery(Session session, String query, Class<T> clazz) {
        return createQuery(session, query, clazz, new HashMap<>());
    }

    <T> Query<T> createQuery(Session session, String query, Class<T> clazz, Map<String, Object> params) {
        Query<T> q = session.createQuery(query, clazz);
        for (String s : params.keySet()) {
            q.setParameter(s, params.get(s));
        }
        return q;
    }
}
