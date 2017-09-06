package com.auction.services;

import com.auction.entities.ProductsEntity;

import java.util.List;

public interface ProductsService<T extends ProductsEntity> {

    List<T> getAll();

    int getRecordsCount();

    List<T> getRecords(int offset, int itemsCount);
}
