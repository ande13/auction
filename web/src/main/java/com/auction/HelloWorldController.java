package com.auction;

import com.auction.entities.ProductsEntity;
import com.auction.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(Model model) {

        List<ProductsEntity> all = productsService.getAll();

        return "index";
    }
}
