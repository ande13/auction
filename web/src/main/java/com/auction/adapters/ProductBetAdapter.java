package com.auction.adapters;

import com.auction.dto.products.ProductBet;
import com.auction.entities.ProductsBetHistoryEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductBetAdapter {

    public ProductBet getProductBet(ProductsBetHistoryEntity entity) {
        return new ProductBet(entity.getProductId(), entity.getPrice(), entity.getCreationDate());
    }
}
