package com.auction.dto.products;

import java.sql.Date;

public class ProductBet {

    private int productId;
    private int price;
    private Date creationDate;

    public ProductBet(int productId, int price, Date creationDate) {
        this.productId = productId;
        this.price = price;
        this.creationDate = creationDate;
    }

    public int getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
