package com.auction.model;

public class BaseModel {

    private static final int ITEMS_PER_PAGE = 10;

    private int itemsPerPage;

    public BaseModel() {
        itemsPerPage = ITEMS_PER_PAGE;
    }

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
