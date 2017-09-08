package com.auction.dao;

import com.auction.entities.ProductsBetHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ProductsBetHistoryDAOImpl extends BaseDAO implements ProductsBetHistoryDAO<ProductsBetHistoryEntity> {

    private static final String PRODUCT_ID = "productId";

    private static final String GET_BETS_COUNT = "select count(1) from ProductsBetHistoryEntity h where h.productId = :productId";
    private static final String GET_RECORDS_BY_PARENT_ID = "from ProductsBetHistoryEntity h where h.productId = :productId order by h.creationDate desc";
    private static final String GET_BET_BY_PARAMS = "select h from ProductsBetHistoryEntity h where h.productId = :productId order by h.creationDate, h.price desc";

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public int getBetsCount(int productId) {
        Map<String, Object> params = new HashMap<>();
        params.put(PRODUCT_ID, productId);
        return hibernateTemplate.execute(session ->
                createQuery(session, GET_BETS_COUNT, Long.class, params).getSingleResult().intValue()
        );
    }

    @Override
    public List<ProductsBetHistoryEntity> getBetsByProductId(int productId, int offset, int itemsCount) {
        Map<String, Object> params = new HashMap<>();
        params.put(PRODUCT_ID, productId);
        return hibernateTemplate.execute(session ->
                createQuery(session, GET_RECORDS_BY_PARENT_ID, ProductsBetHistoryEntity.class, params)
                        .setMaxResults(itemsCount).setFirstResult(offset).list()
        );
    }

    @Override
    public ProductsBetHistoryEntity addBet(int productId, int price) {
        ProductsBetHistoryEntity bet = new ProductsBetHistoryEntity(productId, price, new Date());
        hibernateTemplate.execute(session -> session.save(bet));
        return bet;
    }

    @Override
    public ProductsBetHistoryEntity getLastBet(int productId, int price) {
        Map<String, Object> params = new HashMap<>();
        params.put(PRODUCT_ID, productId);
        return hibernateTemplate.execute(session ->
                createQuery(session, GET_BET_BY_PARAMS, ProductsBetHistoryEntity.class, params)
                        .setMaxResults(1).uniqueResult()
        );
    }
}
