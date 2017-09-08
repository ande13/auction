package com.auction.services;

import com.auction.dao.ProductsBetHistoryDAO;
import com.auction.entities.ProductsBetHistoryEntity;
import com.auction.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsBetHistoryServiceImpl implements ProductsBetHistoryService<ProductsBetHistoryEntity> {

    private static final String LOWER_PRICE_ERROR = "Current price %s is lower than the last price. The last price is %s";
    private static final String EXIST_PRICE_ERROR = "Bet with price %s is already exist";

    @Autowired
    private ProductsBetHistoryDAO<ProductsBetHistoryEntity> historyDAO;

    @Override
    public int getBetsCount(int productId) {
        return historyDAO.getBetsCount(productId);
    }

    @Override
    public List<ProductsBetHistoryEntity> getBetsByProductId(int productId, int offset, int itemsCount) {
        return historyDAO.getBetsByProductId(productId, offset, itemsCount);
    }

    @Override
    public ProductsBetHistoryEntity addBet(int productId, int price) {
        ProductsBetHistoryEntity bet = getBet(productId, price);
        if (bet != null) {
            int betPrice = bet.getPrice();
            if (price < betPrice) {
                throw new BusinessException(String.format(LOWER_PRICE_ERROR, price, betPrice));
            }
            if (betPrice == price) {
                throw new BusinessException(String.format(EXIST_PRICE_ERROR, price));
            }
        }
        return historyDAO.addBet(productId, price);
    }

    @Override
    public ProductsBetHistoryEntity getBet(int productId, int price) {
        return historyDAO.getBet(productId, price);
    }
}
