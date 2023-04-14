DROP TABLE IF EXISTS ecommerce.item;

CREATE TABLE ecommerce.item (
  id BIGINT AUTO_INCREMENT NOT NULL,
   uniq_id VARCHAR(255) NOT NULL,
   availability BIGINT NOT NULL,
   CONSTRAINT pk_item PRIMARY KEY (id)
);