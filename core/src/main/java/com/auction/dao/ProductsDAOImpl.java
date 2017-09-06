package com.auction.dao;


import com.auction.entities.ProductsEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductsDAOImpl implements ProductsDAO<ProductsEntity> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<ProductsEntity> getAll() {
        return hibernateTemplate.loadAll(ProductsEntity.class);
    }

    public int getCountOfRecords() {
        return hibernateTemplate.execute(new HibernateCallback<Integer>() {
            public Integer doInHibernate(Session session) {
                return session.createQuery("select count(1) from ProductsEntity", Long.class).getSingleResult().intValue();
            }
        });
    }

    public List<ProductsEntity> getRecords(final int offset, final int itemsCount) {
        return hibernateTemplate.execute(new HibernateCallback<List<ProductsEntity>>() {
            public List<ProductsEntity> doInHibernate(Session session) {
                Query<ProductsEntity> q = session.createQuery("from ProductsEntity", ProductsEntity.class);
                q.setMaxResults(itemsCount);
                q.setFirstResult(offset);
                return q.list();
            }
        });
    }
}
