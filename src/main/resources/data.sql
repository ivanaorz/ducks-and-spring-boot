DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id int AUTO_INCREMENT primary key,
                       username varchar(255),
                       password varchar(255)
);


INSERT INTO users (username, password) VALUES ("Tony", "123");
INSERT INTO users (username, password) VALUES ("Thor", "123");
INSERT INTO users (username, password) VALUES ("Natasha", "123");
INSERT INTO users (username, password) VALUES ("Stephen", "123");


DROP TABLE IF EXISTS payment;

CREATE TABLE payment (
                       id int AUTO_INCREMENT primary key,
                       username varchar(255),
                       title varchar(255),
                       dateOfPayment date,
                       description varchar(255),
                       category varchar(255),
                       price double (9,2)
);