package com.auction.controller;

import com.auction.exceptions.BusinessException;
import com.auction.model.ProductBetsModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductBetsController {

    @Autowired
    private ProductBetsModel betsModel;

    @RequestMapping(value = "/product/bets", method = RequestMethod.GET)
    public String getBets(@RequestParam int productId) {
        JSONObject json = new JSONObject();
        json.put("items", betsModel.getBets(productId));
        return json.toString();
    }

    @RequestMapping(value = "/product/bets/submit", method = RequestMethod.POST)
    public String submitBet(@RequestParam int productId, @RequestParam  int price) throws BusinessException {
        return new JSONObject(betsModel.addBet(productId, price)).toString();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(BusinessException e) {
        JSONObject error = new JSONObject();
        error.put("error", e.getMessage());
        return error.toString();
    }
}
