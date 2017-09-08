package com.auction.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException e) {
        JSONObject error = new JSONObject();
        error.put("error", e.getMessage());
        return error.toString();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(Exception e) {
        JSONObject error = new JSONObject();
        error.put("error", e.getMessage());
        return error.toString();
    }
}