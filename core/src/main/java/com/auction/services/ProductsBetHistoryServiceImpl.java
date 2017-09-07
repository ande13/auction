package com.auction.services;

import com.auction.dao.ProductsBetHistoryDAO;
import com.auction.entities.ProductsBetHistoryEntity;
import com.auction.exceptions.BusinessException;
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
        ProductsBetHistoryEntity bet = getBet(productId, price);
        if (bet != null && bet.getPrice() == price) {
            throw new BusinessException("Bet with price " + price + " is already exist");
        }
        return historyDAO.addBet(productId, price);
    }

    @Override
    public ProductsBetHistoryEntity getBet(int productId, int price) {
        return historyDAO.getBet(productId, price);
    }
}
