package com.auction.tests;

import com.auction.dao.ProductsBetHistoryDAOImpl;
import com.auction.entities.ProductsBetHistoryEntity;
import com.auction.exceptions.BusinessException;
import com.auction.messages.IMessages;
import com.auction.services.ProductsBetHistoryService;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class TestProductsBetHistory {

    @Autowired
    private ProductsBetHistoryService betHistoryService;

    @Test
    public void testAddBet(@Mocked ProductsBetHistoryDAOImpl mockedBetHistoryDAO) {

        Deencapsulation.setField(betHistoryService, "historyDAO", mockedBetHistoryDAO);
        int productId = 1;
        int lastPrice = 100;

        new Expectations() {{
            betHistoryService.getLastBet(anyInt);
            result = new ProductsBetHistoryEntity(productId, lastPrice, new Date());

            mockedBetHistoryDAO.addBet(anyInt, anyInt);
            result = new ProductsBetHistoryEntity(productId, 200, new Date());
        }};

        {
            ProductsBetHistoryEntity addedEntity = betHistoryService.addBet(productId, 200);
            Assert.assertEquals(200, addedEntity.getPrice());
            Assert.assertEquals(productId, addedEntity.getProductId());
        }

        {
            int price = -100;
            try {
                betHistoryService.addBet(productId, price);
                Assert.fail();
            } catch (BusinessException e) {
                Assert.assertTrue(e.getMessage().equals(String.format(IMessages.LOWER_PRICE_ERROR, price, lastPrice)));
            }
        }

        {
            int price = 100;
            try {
                betHistoryService.addBet(productId, price);
            } catch (BusinessException e) {
                Assert.assertTrue(e.getMessage().equals(String.format(IMessages.EXIST_PRICE_ERROR, price)));
            }
        }
    }

}
