package com.auction.services;

import com.auction.entities.ProductsBetHistoryEntity;

import java.util.List;

public interface ProductsBetHistoryService<T extends ProductsBetHistoryEntity>  {

    List<T> getBetsByProductId(int productId);

    ProductsBetHistoryEntity addBet(int productId, int price);
}
