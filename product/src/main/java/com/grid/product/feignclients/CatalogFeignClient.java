package com.grid.product.feignclients;

import com.grid.product.config.CustomFeignConfiguration;
import com.grid.product.exceptions.ProductNotAvailableException;
import com.grid.product.models.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "catalog-application", configuration = CustomFeignConfiguration.class, fallback = CatalogFeignClient.Fallback.class)
public interface CatalogFeignClient {

    @GetMapping("/catalog/articles/id/{uniqueId}")
    Article getProductByUniqueId(@PathVariable("uniqueId") String uniqueId);

    @GetMapping("/catalog/articles/sku/{sku}")
    List<Article> getProductBySku(@PathVariable("sku") String sku);

    @Component
    class Fallback implements CatalogFeignClient {

        @Override
        public Article getProductByUniqueId(final String uniqueId) {
            return Article.builder()
                    .uniqId("null")
                    .sku("null")
                          .build();
        }

        @Override
        public List<Article> getProductBySku(final String sku) {
            return List.of(Article.builder()
                                   .uniqId("null")
                                   .sku("null").build());
        }
    }

}

