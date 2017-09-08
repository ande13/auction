package com.auction.model;

import com.auction.adapters.ModelsAdapter;
import com.auction.dto.products.ProductBet;
import com.auction.entities.ProductsBetHistoryEntity;
import com.auction.services.ProductsBetHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.auction.adapters.ModelsAdapter.toProductBet;

@Component
public class ProductBetsModel extends BaseModel {

    @Autowired
    private ProductsBetHistoryService<ProductsBetHistoryEntity> historyService;

    public List<ProductBet> getBets(int productId, int pageNumber) {
        List<ProductsBetHistoryEntity> betsByProductId = historyService.getBetsByProductId(productId, getOffset(pageNumber), getItemsPerPage());
        return betsByProductId.stream().map(ModelsAdapter::toProductBet).collect(Collectors.toList());
    }

    public int getBetsCount(int productId) {
        return historyService.getBetsCount(productId);
    }

    public ProductBet addBet(int productId, int price) {
        return toProductBet(historyService.addBet(productId, price));
    }
}
