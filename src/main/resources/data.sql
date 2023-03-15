DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       userId int AUTO_INCREMENT primary key,
                       username varchar(255),
                       password varchar(255)
);


INSERT INTO users (username, password) VALUES ("Tony", "123"),
                                             ("Thor", "123"),
                                             ("Natasha", "123"),
                                             ("Stephen", "123");


DROP TABLE IF EXISTS payment;

CREATE TABLE payment (
                       id int AUTO_INCREMENT primary key,
                       username varchar(255),
                       dateOfPayment date,
                       title varchar(255),
                       description varchar(255),
                       category varchar(255),
                       price double (9,2)
);

INSERT INTO payment (username, dateOfPayment, title, description, category, price) VALUES
    ("Tony", "2010-03-15", "buying equipment", "equipment for the new suit", "equipment", "10 000 000"),
    ("Thor", "2014-05-04", "buying ticket", "ticket to go home", "travel", "10"),
     ("Natasha", "2017-02-04", "buying training clothes", "to train", "training", "10 000"),
    ("Stephen", "2011-05-06", "buying books", "to learn how to travel through universes", "studies", "100");