package com.auction.services;

import com.auction.entities.ProductsEntity;

import java.util.List;

public interface ProductsService {

    List<ProductsEntity> getAll();

    void batchInsert(List<? extends ProductsEntity> products);
}
