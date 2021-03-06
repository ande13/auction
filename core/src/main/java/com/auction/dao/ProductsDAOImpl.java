package com.auction.dao;


import com.auction.entities.ProductsEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductsDAOImpl extends BaseDAO implements ProductsDAO<ProductsEntity> {

    private static final String GET_RECORDS_COUNT = "select count(1) from ProductsEntity";

    private static final String GET_RECORDS = "SELECT\n" +
            "  *\n" +
            "FROM products\n" +
            "  JOIN (SELECT\n" +
            "          product_id,\n" +
            "          count(*) count\n" +
            "        FROM products_bet_history\n" +
            "        GROUP BY product_id) bets ON products.id = bets.product_id\n" +
            "ORDER BY bets.count DESC";

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<ProductsEntity> getAll() {
        return hibernateTemplate.loadAll(ProductsEntity.class);
    }

    public int getRecordsCount() {
        return hibernateTemplate.execute(session -> createQuery(session, GET_RECORDS_COUNT, Long.class).getSingleResult().intValue());
    }

    public List<ProductsEntity> getRecords(final int offset, final int itemsCount) {
        return hibernateTemplate.execute(session -> {
            Query<ProductsEntity> q = session.createNativeQuery(GET_RECORDS, ProductsEntity.class);
            q.setMaxResults(itemsCount);
            q.setFirstResult(offset);
            return q.list();
        });
    }
}
