package com.auction.dao;

import com.auction.entities.ProductsBetHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class ProductsBetHistoryDAOImpl implements ProductsBetHistoryDAO<ProductsBetHistoryEntity> {

    private static final String PRODUCT_ID = "productId";
    private static final String PRICE = "price";

    private static final String GET_RECORDS_BY_PARENT_ID = "from ProductsBetHistoryEntity h where h.productId = :productId order by h.creationDate desc";
    private static final String GET_BET_BY_PARAMS = "from ProductsBetHistoryEntity h where h.productId = :productId and h.price <= :price order by h.price desc";

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<ProductsBetHistoryEntity> getBetsByProductId(int productId) {
        return hibernateTemplate.execute(session ->
                session.createQuery(GET_RECORDS_BY_PARENT_ID, ProductsBetHistoryEntity.class)
                        .setParameter(PRODUCT_ID, productId).list()
        );
    }

    @Override
    @Transactional
    public ProductsBetHistoryEntity addBet(int productId, int price) {
        ProductsBetHistoryEntity bet = new ProductsBetHistoryEntity(productId, price, new Date());
        hibernateTemplate.execute(session -> session.save(bet));
        return bet;
    }

    @Override
    public ProductsBetHistoryEntity getBet(int productId, int price) {
        return hibernateTemplate.execute(session ->
                session.createQuery(GET_BET_BY_PARAMS, ProductsBetHistoryEntity.class)
                        .setParameter(PRODUCT_ID, productId)
                        .setParameter(PRICE, price).setMaxResults(1).uniqueResult()
        );
    }
}
