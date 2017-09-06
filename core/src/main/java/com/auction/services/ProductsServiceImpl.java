package com.auction.services;

import com.auction.dao.ProductsDAO;
import com.auction.entities.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService<ProductsEntity> {

    @Autowired
    private ProductsDAO<ProductsEntity> productsDAO;

    public List<ProductsEntity> getAll() {
        return productsDAO.getAll();
    }

    public int getRecordsCount() {
        return productsDAO.getRecordsCount();
    }

    public List<ProductsEntity> getRecords(int offset, int itemsCount) {
        return productsDAO.getRecords(offset, itemsCount);
    }
}
