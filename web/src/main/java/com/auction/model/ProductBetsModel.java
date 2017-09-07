package com.auction.model;

import com.auction.adapters.ProductBetAdapter;
import com.auction.dto.products.ProductBet;
import com.auction.entities.ProductsBetHistoryEntity;
import com.auction.exceptions.BusinessException;
import com.auction.services.ProductsBetHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductBetsModel extends BaseModel {

    @Autowired
    private ProductsBetHistoryService<ProductsBetHistoryEntity> historyService;

    @Autowired
    private ProductBetAdapter productBetAdapter;

    public List<ProductBet> getBets(int productId) {
        List<ProductsBetHistoryEntity> betsByProductId = historyService.getBetsByProductId(productId);
        return betsByProductId.stream().map(product -> productBetAdapter.getProductBet(product)).collect(Collectors.toList());
    }

    public ProductBet addBet(int productId, int price) throws BusinessException {
        return productBetAdapter.getProductBet(historyService.addBet(productId, price));
    }
}
