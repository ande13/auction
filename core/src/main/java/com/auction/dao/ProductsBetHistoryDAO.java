package com.auction.dao;

import com.auction.entities.ProductsBetHistoryEntity;

import java.util.List;

public interface ProductsBetHistoryDAO<T extends ProductsBetHistoryEntity> {

    List<T> getByParentId(int parentId);
}
