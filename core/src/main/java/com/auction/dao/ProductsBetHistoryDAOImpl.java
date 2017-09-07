package com.auction.dao;

import com.auction.entities.ProductsBetHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductsBetHistoryDAOImpl implements ProductsBetHistoryDAO<ProductsBetHistoryEntity> {

    private static final String GET_RECORDS_BY_PARENT_ID = "from ProductsBetHistoryEntity h where h.productId = :productId order by h.creationDate desc";

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<ProductsBetHistoryEntity> getBetsByProductId(int productId) {
        return hibernateTemplate.execute(session ->
                session.createQuery(GET_RECORDS_BY_PARENT_ID, ProductsBetHistoryEntity.class)
                        .setParameter("productId", productId).list()
        );
    }

}
