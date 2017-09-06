package com.auction.adapters;

import com.auction.dto.products.Product;
import com.auction.entities.ProductsEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapter {

    public Product getProduct(ProductsEntity productsEntity) {
        return new Product(productsEntity.getId(), productsEntity.getName());
    }
}
