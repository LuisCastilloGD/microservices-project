package com.grid.product.feignclients;

import com.grid.product.config.CustomFeignConfiguration;
import com.grid.product.models.Article;
import com.grid.product.models.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-application", configuration = CustomFeignConfiguration.class ,fallback = InventoryFeignClient.Fallback.class)
public interface InventoryFeignClient {

    @GetMapping("/inventory/items/{uniqueId}")
    Item getItemByUniqueId(@PathVariable("uniqueId") String uniqueId);

    @Component
    class Fallback implements InventoryFeignClient {
        @Override
        public Item getItemByUniqueId(final String uniqueId) {
            return Item.builder()
                    .uniqId("null")
                    .availability(1L)
                       .build();
        }
    }

}
