package com.auction.model;

public class BaseModel {

    private int itemsPerPage;

    public BaseModel(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    protected int getOffset(int pageNumber) {
        return pageNumber < 1 ? 0 : (pageNumber - 1) * itemsPerPage;
    }
}
