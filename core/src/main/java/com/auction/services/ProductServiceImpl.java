package com.auction.services;

import com.auction.dao.ProductDAO;
import com.auction.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<ProductEntity> getAll() {
        return productDAO.getAll();
    }
}
