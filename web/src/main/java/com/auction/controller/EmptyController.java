package com.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmptyController extends BaseController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String openDefaultPage() {
        return "redirect:/auction/products";
    }
}
