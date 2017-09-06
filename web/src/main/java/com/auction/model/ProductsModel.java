package com.auction.model;

import com.auction.entities.ProductsEntity;
import com.auction.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ProductsModel {

    @Autowired
    private ProductsService<ProductsEntity> productsService;

    private int pageNumber;
    private int itemsPerPage;

    private int countOfAllRecords;

    private List<ProductsEntity> productsItems;

    @PostConstruct
    public void init() {
        pageNumber = 1;
        itemsPerPage = 10;
    }

    public void redraw(int numberOfPage) {
        this.pageNumber = numberOfPage;
        this.productsItems = productsService.getRecords(getOffset(), itemsPerPage);
        this.countOfAllRecords = productsService.getCountOfRecords();
    }

    public int getProductsItemsSize() {
        return productsItems.size();
    }

    public List<ProductsEntity> getProductsItems() {
        return productsItems;
    }

    private int getOffset() {
        return pageNumber < 1 ? 0 : (pageNumber - 1) * itemsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageCount() {
        return countOfAllRecords / itemsPerPage + 1;
    }
}
