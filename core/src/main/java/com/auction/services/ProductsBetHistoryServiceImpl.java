package com.auction.services;

import com.auction.dao.ProductsBetHistoryDAO;
import com.auction.entities.ProductsBetHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsBetHistoryServiceImpl implements ProductsBetHistoryService<ProductsBetHistoryEntity> {

    @Autowired
    private ProductsBetHistoryDAO<ProductsBetHistoryEntity> historyDAO;

    @Override
    public List<ProductsBetHistoryEntity> getBetsByProductId(int productId) {
        return historyDAO.getBetsByProductId(productId);
    }

    @Override
    public ProductsBetHistoryEntity addBet(int productId, int price) {
        return historyDAO.addBet(productId, price);
    }
}
