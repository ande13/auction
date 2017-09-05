package com.auction;

import com.auction.entities.ProductEntity;
import com.auction.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(Model model) {

        List<ProductEntity> all = productService.getAll();

        return "index";
    }
}
