package com.auction.services;

import com.auction.dao.ProductsBetHistoryDAO;
import com.auction.entities.ProductsBetHistoryEntity;
import com.auction.exceptions.BusinessException;
import com.auction.messages.IMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsBetHistoryServiceImpl implements ProductsBetHistoryService<ProductsBetHistoryEntity> {

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
        ProductsBetHistoryEntity bet = getLastBet(productId);
        if (bet != null) {
            int betPrice = bet.getPrice();
            if (price < betPrice) {
                throw new BusinessException(String.format(IMessages.LOWER_PRICE_ERROR, price, betPrice));
            }
            if (betPrice == price) {
                throw new BusinessException(String.format(IMessages.EXIST_PRICE_ERROR, price));
            }
        }
        return historyDAO.addBet(productId, price);
    }

    @Override
    public ProductsBetHistoryEntity getLastBet(int productId) {
        return historyDAO.getLastBet(productId);
    }
}
