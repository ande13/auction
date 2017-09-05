package com.auction.dao;


import com.auction.entities.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void batchInsert(List<? extends ProductsEntity> products) {
        hibernateTemplate.saveOrUpdate(products);
    }
}
