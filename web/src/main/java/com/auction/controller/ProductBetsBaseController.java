package com.auction.controller;

import com.auction.model.ProductBetsModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductBetsBaseController extends BaseController {

    @Autowired
    private ProductBetsModel betsModel;

    @RequestMapping(value = "/product/bets", method = RequestMethod.GET)
    public String getBets(@RequestParam int productId, @RequestParam int pageNumber) {
        JSONObject json = new JSONObject();
        json.put("items", betsModel.getBets(productId, pageNumber));
        return json.toString();
    }

    @RequestMapping(value = "/product/bets/count", method = RequestMethod.GET)
    public String getBetsCount(@RequestParam int productId) {
        return String.valueOf(betsModel.getBetsCount(productId));
    }

    @RequestMapping(value = "/product/bets/submit", method = RequestMethod.POST)
    public String submitBet(@RequestParam int productId, @RequestParam  int price) {
        return new JSONObject(betsModel.addBet(productId, price)).toString();
    }

}
