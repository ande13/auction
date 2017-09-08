package com.auction.controller;

import com.auction.model.ProductsModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/auction")
public class ProductsBaseController extends BaseController {

    @Autowired
    private ProductsModel productsModel;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showProducts() {
        return new ModelAndView("index", "productsModel", productsModel);
    }

    @ResponseBody
    @RequestMapping(value = "/products/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getData(@RequestParam int pageNumber) {
        JSONObject json = new JSONObject();
        json.put("items", productsModel.getProductsItems(pageNumber));
        return json.toString();
    }
}
