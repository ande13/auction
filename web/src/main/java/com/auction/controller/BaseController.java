package com.auction.controller;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {

    private static final Logger logger = Logger.getLogger(BaseController.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException e) {
        logger.error(e.getMessage(), e);
        JSONObject error = new JSONObject();
        error.put("error", e.getMessage());
        return error.toString();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(Exception e) {
        logger.error(e.getMessage(), e);
        JSONObject error = new JSONObject();
        error.put("error", e.getMessage());
        return error.toString();
    }
}
