package com.auction.dao;

import com.auction.entities.ProductsBetHistoryEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductsBetHistoryDAOImpl implements ProductsBetHistoryDAO<ProductsBetHistoryEntity> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<ProductsBetHistoryEntity> getByParentId(int parentId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductsBetHistoryEntity.class);
        criteria.add(Restrictions.eq("parent_id", parentId));
        return (List<ProductsBetHistoryEntity>) hibernateTemplate.findByCriteria(criteria);
    }
}
