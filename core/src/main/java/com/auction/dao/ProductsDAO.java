package com.auction.dao;

import com.auction.entities.ProductsEntity;

import java.util.List;

public interface ProductsDAO<T extends ProductsEntity> {

    List<T> getAll();

    int getCountOfRecords();

    List<T> getRecords(int offset, int itemsCount);
}
