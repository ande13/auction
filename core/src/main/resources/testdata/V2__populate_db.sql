DELIMITER $$
CREATE PROCEDURE generate_test_data()
  BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE bets INT DEFAULT 0;
    DECLARE j INT DEFAULT 0;
    WHILE i < 1000 DO
      INSERT INTO products (id, name) VALUES (i, concat('product_', i));
      SET bets = FLOOR((RAND() * (1000 - 100)) + 100);
      WHILE j < bets DO
        INSERT INTO products_bet_history (product_id, price, creation_date) VALUES (i, RAND() * 2000 + 200, now());
        SET j = j + 1;
      END WHILE;
      SET j = 0;
      SET i = i + 1;
    END WHILE;
  END$$
DELIMITER ;

CALL generate_test_data();