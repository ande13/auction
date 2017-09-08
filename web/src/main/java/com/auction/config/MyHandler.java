package com.auction.config;

import com.auction.model.ProductsModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class MyHandler extends TextWebSocketHandler {

    @Autowired
    private ProductsModel productsModel;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();
        if ("CHECK-DATA".equals(payload)) {
            int count = productsModel.getCountOfAllRecords();
            JSONObject response = new JSONObject();
            response.put("count", count);
            session.sendMessage(new TextMessage(response.toString()));
        }
    }
}
