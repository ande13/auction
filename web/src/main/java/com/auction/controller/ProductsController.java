package com.auction.controller;

import com.auction.entities.ProductsEntity;
import com.auction.model.ProductsModel;
import com.auction.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/auction")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    private final ProductsModel productsModel;

    @Autowired
    public ProductsController(ProductsModel productsModel) {
        this.productsModel = productsModel;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showProducts(Model model) {
        List<ProductsEntity> products = productsService.getAll();
        model.addAttribute("products", products);
        return "index";
    }
}
