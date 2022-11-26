DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id        INTEGER      NOT NULL AUTO_INCREMENT,
  userId    VARCHAR(32)  NOT NULL,
  password  VARCHAR(100) NOT NULL,
  name      VARCHAR(32)  NOT NULL,
  role      VARCHAR(48)  NOT NULL,
  phone     VARCHAR(32)  NOT NULL,
  email     VARCHAR(32)  NOT NULL,
  address   VARCHAR(100) NOT NULL,
  createdAt DATETIME     NOT NULL,
  updatedAt DATETIME     NOT NULL,

  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS shops;
CREATE TABLE shops
(
  id            BIGINT      NOT NULL AUTO_INCREMENT,
  shopName      VARCHAR(48) NOT NULL,
  shopPhone     VARCHAR(48) NOT NULL,
  status        VARCHAR(48) NOT NULL,
  shopOpenTime  DATETIME    NOT NULL,
  shopCloseTime DATETIME    NOT NULL,
  createdAt     DATETIME    NOT NULL,
  updatedAt     DATETIME    NOT NULL,

  PRIMARY KEY (id)
);