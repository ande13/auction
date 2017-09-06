package com.auction.model;

import com.auction.adapters.ProductAdapter;
import com.auction.dto.products.Product;
import com.auction.entities.ProductsEntity;
import com.auction.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsModel {

    @Autowired
    private ProductsService<ProductsEntity> productsService;

    @Autowired
    private ProductAdapter productAdapter;

    private int itemsPerPage;

    private int countOfAllRecords;

    @PostConstruct
    public void init() {
        itemsPerPage = 10;
        countOfAllRecords = productsService.getRecordsCount();
    }

    public void reInit(int numberOfPage) {
        this.countOfAllRecords = productsService.getRecordsCount();
    }

    public List<Product> getProductsItems(int pageNumber) {
        List<ProductsEntity> records = productsService.getRecords(getOffset(pageNumber), itemsPerPage);
        return records.stream().map(record -> productAdapter.getProduct(record)).collect(Collectors.toList());
    }

    private int getOffset(int pageNumber) {
        return pageNumber < 1 ? 0 : (pageNumber - 1) * itemsPerPage;
    }

    public int getCountOfAllRecords() {
        return countOfAllRecords;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }
}
