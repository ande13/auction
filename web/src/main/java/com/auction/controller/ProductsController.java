package com.auction.controller;

import com.auction.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/auction")
public class ProductsController {

    @Autowired
    private ProductsModel productsModel;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showProducts() {
        return "redirect:/auction/products/page/1";
    }

    @RequestMapping(value = "/products/page/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView showProducts(@PathVariable("pageNumber") Integer pageNumber) {
        productsModel.redraw(pageNumber);
        return new ModelAndView("index", "productsModel", productsModel);
    }
}
