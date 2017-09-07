package com.auction.dao;

import com.auction.entities.ProductsBetHistoryEntity;

import java.util.List;

public interface ProductsBetHistoryDAO<T extends ProductsBetHistoryEntity> {

    List<T> getBetsByProductId(int productId);

    ProductsBetHistoryEntity addBet(int productId, int price);

    ProductsBetHistoryEntity getBet(int productId, int price);
}
