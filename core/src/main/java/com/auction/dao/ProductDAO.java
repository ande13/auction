package com.auction.dao;

import com.auction.entities.ProductEntity;

import java.util.List;

public interface ProductDAO {

    List<ProductEntity> getAll();
}
