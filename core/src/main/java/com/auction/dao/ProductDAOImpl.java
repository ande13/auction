package com.auction.dao;


import com.auction.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<ProductEntity> getAll() {
        return hibernateTemplate.loadAll(ProductEntity.class);
    }
}
