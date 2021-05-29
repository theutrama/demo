DROP TABLE IF EXISTS user;

CREATE TABLE user (
                              userid INT AUTO_INCREMENT PRIMARY KEY,
                              first_name VARCHAR(30) NOT NULL,
                              last_name VARCHAR(30) NOT NULL,
                              email VARCHAR(30) NOT NULL,
                              username VARCHAR(20) NOT NULL
);