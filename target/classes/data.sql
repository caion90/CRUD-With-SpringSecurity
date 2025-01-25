CREATE DATABASE IF NOT EXISTS demo;
USE demo;

CREATE TABLE buys (
    id INT PRIMARY KEY AUTO_INCREMENT,
    version INT DEFAULT 0
);

CREATE TABLE items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    price DECIMAL(5,2),
    name VARCHAR(100),
    buy_id INT,
    version INT DEFAULT 0,
    FOREIGN KEY (buy_id) REFERENCES buys(id)
);

CREATE TABLE items_buy (
    items_id INT NOT NULL,
    buy_id INT NOT NULL,
    PRIMARY KEY (buy_id, items_id)
);

INSERT INTO buys (id, version) VALUES (1, 0);
INSERT INTO buys (id, version) VALUES (2, 0);

INSERT INTO items (price, name, buy_id, version) VALUES (2.50, 'coca cola', 1, 0);
INSERT INTO items (price, name, buy_id, version) VALUES (4.50, 'batata chips', 1, 0);
INSERT INTO items (price, name, buy_id, version) VALUES (3.50, 'pepsi', 1, 0);
INSERT INTO items (price, name, buy_id, version) VALUES (2.50, 'fanta', 1, 0);

INSERT INTO items (price, name, buy_id, version) VALUES (2.50, 'coca cola - 2L', 2, 0);
INSERT INTO items (price, name, buy_id, version) VALUES (4.50, 'batata chips', 2, 0);


INSERT INTO items_buy (items_id, buy_id) VALUES (1, 0);
INSERT INTO items_buy (items_id, buy_id) VALUES (4, 0);
INSERT INTO items_buy (items_id, buy_id) VALUES (3, 1);
INSERT INTO items_buy (items_id, buy_id) VALUES (1, 1);
INSERT INTO items_buy (items_id, buy_id) VALUES (2, 2);
INSERT INTO items_buy (items_id, buy_id) VALUES (1, 2);