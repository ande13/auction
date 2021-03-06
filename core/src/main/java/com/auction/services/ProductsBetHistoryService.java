package com.auction.services;

import com.auction.entities.ProductsBetHistoryEntity;

import java.util.List;

public interface ProductsBetHistoryService<T extends ProductsBetHistoryEntity>  {

    int getBetsCount(int productId);

    List<T> getBetsByProductId(int productId, int offset, int itemsCount);

    ProductsBetHistoryEntity addBet(int productId, int price);

    ProductsBetHistoryEntity getLastBet(int productId);
}
