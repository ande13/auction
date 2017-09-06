CREATE TABLE products (
  id int not null,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);
CREATE INDEX product_name_index ON products (name);
CREATE INDEX product_id_index ON products (id);
CREATE INDEX product_id_name_index ON products (id, name);

CREATE TABLE products_bet_history (
  id int not null AUTO_INCREMENT,
  product_id int not null,
  price INT NOT NULL,
  creation_date DATETIME NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);
CREATE INDEX product_history_id_index ON products_bet_history (id);
CREATE INDEX product_history_product_id_index ON products_bet_history (product_id);
CREATE INDEX product_history_name_index ON products_bet_history (price);
CREATE INDEX product_history_creation_date_index ON products_bet_history (creation_date);
CREATE INDEX product_history_product_id_name_index ON products_bet_history (product_id, price);
CREATE INDEX product_history_product_id_name_date_index ON products_bet_history (product_id, price, creation_date);