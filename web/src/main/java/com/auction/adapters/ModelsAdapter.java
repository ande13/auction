package com.auction.adapters;

import com.auction.dto.products.Product;
import com.auction.dto.products.ProductBet;
import com.auction.entities.ProductsBetHistoryEntity;
import com.auction.entities.ProductsEntity;

public class ModelsAdapter {

    private ModelsAdapter() {
    }

    public static Product toProduct(ProductsEntity productsEntity) {
        return new Product(productsEntity.getId(), productsEntity.getName());
    }

    public static ProductBet toProductBet(ProductsBetHistoryEntity entity) {
        return new ProductBet(entity.getProductId(), entity.getPrice(), entity.getCreationDate());
    }
}
