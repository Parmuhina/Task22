CREATE TABLE IF NOT EXISTS product (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  price DECIMAL NOT NULL,
  category VARCHAR(300) NULL,
  percent DECIMAL,
  PRIMARY KEY (id)
)
  AUTO_INCREMENT = 1;

  CREATE TABLE IF NOT EXISTS category (
                                        id BIGINT NOT NULL AUTO_INCREMENT,
                                        customerId BIGINT,
                                        category VARCHAR(300) NULL,
                                        PRIMARY KEY (id),
                                        FOREIGN KEY (customerId) REFERENCES product (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

    SELECT name, price, percent, category FROM product left join category on product.id = category.customerId;