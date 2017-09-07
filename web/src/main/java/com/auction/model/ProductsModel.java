package com.auction.model;

import com.auction.adapters.ModelsAdapter;
import com.auction.dto.products.Product;
import com.auction.entities.ProductsEntity;
import com.auction.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsModel extends BaseModel {

    @Autowired
    private ProductsService<ProductsEntity> productsService;

    private int countOfAllRecords;

    @PostConstruct
    public void init() {
        countOfAllRecords = productsService.getRecordsCount();
    }

    public List<Product> getProductsItems(int pageNumber) {
        List<ProductsEntity> records = productsService.getRecords(getOffset(pageNumber), getItemsPerPage());
        return records.stream().map(ModelsAdapter::toProduct).collect(Collectors.toList());
    }

    public int getCountOfAllRecords() {
        return countOfAllRecords;
    }
}
