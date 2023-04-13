DROP TABLE IF EXISTS ecommerce.article;

CREATE TABLE ecommerce.article (
  id BIGINT AUTO_INCREMENT NOT NULL,
   uniq_id VARCHAR(255) NOT NULL,
   sku VARCHAR(255) NULL,
   name_title TEXT NULL,
   `description` TEXT NULL,
   list_price VARCHAR(255) NULL,
   sale_price VARCHAR(255) NULL,
   category VARCHAR(255) NULL,
   category_tree VARCHAR(255) NULL,
   average_product_rating VARCHAR(255) NULL,
   product_url TEXT NULL,
   product_image_urls TEXT NULL,
   brand VARCHAR(255) NULL,
   total_number_reviews VARCHAR(255) NULL,
   reviews TEXT NULL,
   CONSTRAINT pk_article PRIMARY KEY (id)
);