CREATE DATABASE `LIBRARY`;

USE LIBRARY;

/*每一类书*/
CREATE TABLE IF NOT EXISTS `BOOKS`
(
    -- 书类别编号: S：科学, H：历史, L:文学， A：艺术
    `SORT`   VARCHAR(20) PRIMARY KEY COMMENT '书籍种类ID',
    `NAME`   VARCHAR(40),
    `AUTHOR` VARCHAR(40),
    `SUM`    INT(12),
    `EXISTS` INT(12)
);

CREATE TABLE IF NOT EXISTS `READER`
(
    `ID`    INT(12) PRIMARY KEY AUTO_INCREMENT,
    `NAME`  VARCHAR(20),
    `PASSWORD` VARCHAR(20) DEFAULT NULL,
-- 等级：
    `GRADE` INT(12)
);

CREATE TABLE IF NOT EXISTS `ADMIN`
(
    `NAME`  VARCHAR(20) PRIMARY KEY,
    `PASSWORD` VARCHAR(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `GRADE`
(
-- 等级：
    `ID`  INT(12) PRIMARY KEY AUTO_INCREMENT,
-- 可以借多少本书
    `MAX` INT(12)
);

/*每一本书*/
CREATE TABLE `BOOK`
(
    `ID`     INT(12) PRIMARY KEY AUTO_INCREMENT,
-- 书类别编号
    `SORT`   VARCHAR(20),
    `NAME`   VARCHAR(40),
    `AUTHOR` VARCHAR(40),
-- 状态：1 可借， 2 已借出， 3 保留不可借出
    `STATUS` INT(12)
);

INSERT INTO `BOOKS`
VALUES ('S0001', 'The Selfish Gene', 'Clinton Richard Dawkins', '4', '4'),
       ('H0001', 'A Short History of Nearly Everything', 'Bill Bryson', '2', '2');

INSERT INTO `BOOK`
VALUES (1001, 'S0001', 'The Selfish Gene', 'Clinton Richard Dawkins', '1'),
       (1002, 'S0001', 'The Selfish Gene', 'Clinton Richard Dawkins', '1'),
       (1003, 'S0001', 'The Selfish Gene', 'Clinton Richard Dawkins', '1'),
       (1004, 'S0001', 'The Selfish Gene', 'Clinton Richard Dawkins', '1'),
       (2005, 'H0001', 'A Short History of Nearly Everything', 'Bill Bryson', '1'),
       (2006, 'H0001', 'A Short History of Nearly Everything', 'Bill Bryson', '1');

INSERT INTO `GRADE`
VALUES (1, 1),
       (2, 5),
       (3, 10);

INSERT INTO `ADMIN`
VALUES ('admin', 'a123');