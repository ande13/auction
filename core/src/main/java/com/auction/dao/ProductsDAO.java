package com.auction.dao;

import com.auction.entities.ProductsEntity;

import java.util.List;

public interface ProductsDAO<T extends ProductsEntity> {

    List<T> getAll();

    int getRecordsCount();

    List<T> getRecords(int offset, int itemsCount);
}
