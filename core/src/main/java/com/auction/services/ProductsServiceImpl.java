package com.auction.services;

import com.auction.dao.ProductsDAO;
import com.auction.entities.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsDAO productsDAO;

    public List<ProductsEntity> getAll() {
        return productsDAO.getAll();
    }

    public void batchInsert(List<? extends ProductsEntity> products) {
        productsDAO.batchInsert(products);
    }
}
