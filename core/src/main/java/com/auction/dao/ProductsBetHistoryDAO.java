package com.auction.dao;

import com.auction.entities.ProductsBetHistoryEntity;

import java.util.List;

public interface ProductsBetHistoryDAO<T extends ProductsBetHistoryEntity> {

    int getBetsCount(int productId);

    List<T> getBetsByProductId(int productId, int offset, int itemsCount);

    ProductsBetHistoryEntity addBet(int productId, int price);

    ProductsBetHistoryEntity getBet(int productId, int price);
}
